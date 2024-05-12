public class Command {
    private ENUM_COMMAND command;
    private ByteCode instruction;
    private Integer replace;

    public Command(ENUM_COMMAND _command) {
        this.command = _command;
    }

    public Command(ENUM_COMMAND _command, ByteCode _instruction) {
        this.command = _command;
        this.instruction = _instruction;
    }

    public Command(ENUM_COMMAND _command, ByteCode _instruction, Integer _replace) {
        this.command = _command;
        this.instruction = _instruction;
        this.replace = _replace;
    }

    public boolean execute(Engine _engine) {
        //pseudo
        if(1 != 0) {
            return true;
        } else {return false;}
    }
}
