public class ByteCodeParser {

    public static ByteCode parse(String _s, String _n) {
        switch (_s.toLowerCase()) {
            case "push":
                return new ByteCode(ENUM_BYTECODE.PUSH, Integer.parseInt(_n));
            case "load":
                return new ByteCode(ENUM_BYTECODE.LOAD, Integer.parseInt(_n));
            case "store":
                return new ByteCode(ENUM_BYTECODE.STORE, Integer.parseInt(_n));
        } return null;
    }

    public static ByteCode parse(String _s) {
        switch (_s.toLowerCase()) {
            case "add":
                return new ByteCode(ENUM_BYTECODE.ADD);
            case "sub":
                return new ByteCode(ENUM_BYTECODE.SUB);
            case "mul":
                return new ByteCode(ENUM_BYTECODE.MUL);
            case "div":
                return new ByteCode(ENUM_BYTECODE.DIV);
            case "out":
                return new ByteCode(ENUM_BYTECODE.OUT);
            case "halt":
                return new ByteCode(ENUM_BYTECODE.HALT);
        } return null;
    }
}
