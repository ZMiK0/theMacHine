import java.util.Scanner;

public class Engine {
    private ByteCode program;
    private boolean end;

    public void start() {
        Scanner sc = new Scanner(System.in);

        Memory memory = new Memory();
        OperandStack stack = new OperandStack();

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

    public void end() {
        this.end = true;
    }
}

/*
Comienza la ejecución de NEWINST PUSH 22
Programa almacenado:
0: PUSH 22
 */
