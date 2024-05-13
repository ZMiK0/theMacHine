public class ByteCodeProgram {
    private ByteCode[] program;
    private int num_elements;
    private int size;

    public ByteCodeProgram() {
        this.program = new ByteCode[this.size];
        this.size = 10;
        this.num_elements = 0;
    }
    //metodo para añadir un bytecode al programa. Bytecode
    //metodo para inicializar el programa. A este le entra una cpu de engine
    //metodo para colocar un bytecode en una instruccion. Bytecode Int
    //metodo devolver instruccion i bytecode.
}
