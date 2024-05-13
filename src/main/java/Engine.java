import java.util.Scanner;

public class Engine {
    private ByteCodeProgram program;
    private boolean end;
    private CPU cpu;

    public void start() {
        Scanner sc = new Scanner(System.in);

        while(!this.end) {
            System.out.print("[belz@maquinavirtual] -> ");
            String instruccion = sc.next();
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

        return true;
    }

    public boolean commandNewinst() {

        return true;
    }

    public boolean commandReset() {
        System.out.println("Borrando el estado de la máquina");
        return true;
    }
}



/*
Comienza la ejecución de NEWINST PUSH 22
Programa almacenado:
0: PUSH 22
 */
