import java.util.Locale;
import java.util.Scanner;

public class Engine {
    private ByteCodeProgram program;
    private boolean end;
    private CPU cpu;

    private String colorTerminal = "\u001b[36m";
    public static String colorError = "\u001b[35m";
    public static String colorComando = "\u001b[37m";
    public static String colorBlanco = "\033[0m";
    private String colorBorrar = "\u001b[91m";


    /**
     * Limpia la consola
     */
    public void clearScreen() {
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }

    public Engine() {
        program = new ByteCodeProgram();
        end = false;
        cpu = new CPU();
    }

    /**
     * Comienza la ejecución
     */
    public void start() {
        Scanner sc = new Scanner(System.in);

        while (!this.end) {

            System.out.print(colorTerminal + "[belz@maquinavirtual] -> " + colorBlanco);
            String instruccion = sc.nextLine();
            Command comando = CommandParser.parse(instruccion);
            System.out.println("Comienza la ejecución de [" + colorComando + instruccion.toUpperCase() + colorBlanco + "]");
            if (comando != null) {
                if (comando.execute(this)) {

                } else {
                    System.out.println(colorError + "No se ha podido ejecutar, ejecución incorrecta." + colorBlanco);
                }
            } else {
                System.out.println(colorError + "No se ha podido ejecutar, comando incorrecto." + colorBlanco);
            }

        }
    }

    /**
     * Comando que finaliza el programa
     * @return
     */
    public boolean commandEnd() {
        System.out.println(colorBorrar + "---APAGANDO EL SISTEMA---");
        this.end = true;
        return true;
    }

    /**
     * Comando que muestra la pantalla de ayuda
     * @return
     */
    public boolean commandHelp() {
        System.out.println(
               colorComando + "HELP" + colorBlanco + ": Muestra esta ayuda\n" +
               colorComando + "QUIT" + colorBlanco + ": Cierra la aplicacion\n" +
               colorComando + "RUN" + colorBlanco + ": Ejecuta el programa\n" +
               colorComando + "NEWINST BYTECODE" + colorBlanco +": Introduce una nueva instrucción al programa\n" +
               colorComando + "RESET" + colorBlanco +": Vacia el programa actual\n" +
               colorComando + "REPLACE N" + colorBlanco +": Reemplaza la instruccion N por la solicitada al usuario"
        );
        return true;
    }

    /**
     * Comando que ejecuta el programa
     * @return
     */
    public boolean commandRun() {
        System.out.println(this.program.runProgram(this.cpu));
        System.out.println(this.program.toString());
        return true;
    }

    /**
     * Comando que añade un ByteCode al programa
     * @param _comando
     * @return
     */
    public boolean commandNewinst(Command _comando) {
        if (_comando.getInstruction() != null) {
            this.program.addByteCode(_comando.getInstruction());
            System.out.println(this.program.toString());
            return true;
        } else {
            return false;
        }
    }

    /**
     * Comando que resetea el programa
     * @return
     */
    public boolean commandReset() {
        if (this.cpu.reset()) {
            clearScreen();
            System.out.println(colorBorrar + "Borrando el estado de la máquina" + colorBlanco);
            this.program.reset();
        } else {
            System.out.println("Algo ha fallado");
        }
        return true;
    }

    /**
     * Comando que reemplaza un Bytecode del programa
     * @param _comando
     * @return
     */
    public boolean commandReplace(Command _comando) {
        if (_comando != null) {
            Scanner sc = new Scanner(System.in);
            System.out.print("[belz@maquinavirtual] -> Nuevo Bytecode: ");
            String instruccion = sc.nextLine();
            String[] particion = instruccion.split(" ");
            if (particion.length == 1) {
                ByteCode x = ByteCodeParser.parse(particion[0]);
                if (x != null) {
                    this.program.replaceByteCode(x, _comando.getReplace());
                } else {
                    return false;
                }
            } else {
                ByteCode x = ByteCodeParser.parse(particion[0], particion[1]);
                if (x != null) {
                    this.program.replaceByteCode(x, _comando.getReplace());
                } else {
                    return false;
                }
            }
            System.out.println(this.program.toString());
            return true;

        } else {
            System.out.println(this.program.toString());
            return false;
        }
    }
}