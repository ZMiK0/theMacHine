public class ByteCode {
    private ENUM_BYTECODE name;
    private int param;


    public ByteCode(ENUM_BYTECODE _enumBytecode) {
        this.name = _enumBytecode;
    }

    public ByteCode(ENUM_BYTECODE _enumBytecode, int _param) {
        this.param = _param;
        this.name = _enumBytecode;
    }

    //to string
    //get instruction
    //get param

}
