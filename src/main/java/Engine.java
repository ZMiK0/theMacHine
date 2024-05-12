import java.util.Scanner;

public class Engine {
    private ByteCode program;
    private boolean end;

    public void start() {
        Scanner sc = new Scanner(System.in);

        Memory memory = new Memory();
        OperandStack stack = new OperandStack();

        System.out.print("-> ");
        String instrucción = sc.next();
        Command comando = CommandParser.parse(instrucción);




    }
}
