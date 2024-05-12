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
        switch (this.command) {
            case HELP: System.out.println(
                    "HELP: Muestra esta ayuda\n" +
                            "QUIT: Cierra la aplicacion\n" +
                            "RUN: Ejecuta el programa\n" +
                            "NEWINST BYTECODE: Introduce una nueva instrucción al programa\n" +
                            "RESET: Vacia el programa actual\n" +
                            "REPLACE N: Reemplaza la instruccion N por la solicitada al usuario"
            ); return true;
            case QUIT:
                System.out.println("APAGANDO EL SISTEMA");
                _engine.end();
                return true;
            default:
                System.out.println("No se ha podido ejecutar el comando");
                return false;
        }
    }
}