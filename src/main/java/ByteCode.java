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

    public String toString() {
        return this.name.toString() + " " + param;
    }

    public ENUM_BYTECODE getName() {
        return this.name;
    }
    public int getParam() {
        return this.param;
    }

}
