import java.util.Scanner;

public class Engine {
    private ByteCodeProgram program;
    private boolean end;
    private CPU cpu;

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
            if(comando.execute(this)) {
                System.out.println();
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
        System.out.println(
                "Comienza la ejecución de RUN"
        );
        program.runProgram(this.cpu);
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
            System.out.println("Borrando el estado de la máquina");
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
            Command xcomando = CommandParser.parse(instruccion);
            this.program.replaceByteCode(xcomando.getInstruction(), _comando.getReplace());
            this.program.toString();
            return true;
        } else {
            return false;
        }
    }


}



/*
Comienza la ejecución de NEWINST PUSH 22
Programa almacenado:
0: PUSH 22
 */
