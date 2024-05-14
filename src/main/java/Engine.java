import java.util.Locale;
import java.util.Scanner;

public class Engine {
    private ByteCodeProgram program;
    private boolean end;
    private CPU cpu;

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


    public void start() {
        Scanner sc = new Scanner(System.in);

        while(!this.end) {
            System.out.print("[belz@maquinavirtual] -> ");
            String instruccion = sc.nextLine();
            Command comando = CommandParser.parse(instruccion);
            System.out.println("Comienza la ejecución de [" + instruccion.toUpperCase() + "]");
            if(comando.execute(this)) {

            } else {
                System.out.println("No se ha podido ejecutar");
            }
        }
    }

    public boolean commandEnd() {
        System.out.println("APAGANDO EL SISTEMA");
        this.end = true;
        return true;
    }

    public boolean commandHelp() {
        System.out.println(
                "HELP: Muestra esta ayuda\n" +
                        "QUIT: Cierra la aplicacion\n" +
                        "RUN: Ejecuta el programa\n" +
                        "NEWINST BYTECODE: Introduce una nueva instrucción al programa\n" +
                        "RESET: Vacia el programa actual\n" +
                        "REPLACE N: Reemplaza la instruccion N por la solicitada al usuario"
        ); return true;
    }

    public boolean commandRun() {
        System.out.println(this.program.runProgram(this.cpu));
        System.out.println(this.program.toString());
        return true;
    }

    public boolean commandNewinst(Command _comando) {
        if (_comando.getInstruction() != null) {
            this.program.addByteCode(_comando.getInstruction());
            System.out.println(this.program.toString());
            return true;
        } else {
            return false;
        }
    }

    public boolean commandReset() {
        if(this.cpu.reset()) {
            this.clearScreen();
            System.out.println("Borrando el estado de la máquina");
            this.program.reset();
        } else {
            System.out.println("Algo ha fallado");
        }
        return true;
    }

    public boolean commandReplace(Command _comando) {
        if (_comando != null) {
            Scanner sc = new Scanner(System.in);
            System.out.print("[belz@maquinavirtual] -> Nuevo Bytecode: ");
            String instruccion = sc.nextLine();
            String[] particion = instruccion.split(" ");
            if(particion.length == 1) {
                ByteCode x = ByteCodeParser.parse(particion[0]);
                this.program.replaceByteCode(x, _comando.getReplace());
            } else {
                ByteCode x = ByteCodeParser.parse(particion[0], particion[1]);
                this.program.replaceByteCode(x, _comando.getReplace());
            }
            System.out.println(this.program.toString());
            return true;
        } else {
            System.out.println(this.program.toString());
            return false;
        }
    }


}



/*
Comienza la ejecución de NEWINST PUSH 22
Programa almacenado:
0: PUSH 22
 */
