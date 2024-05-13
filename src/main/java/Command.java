public class Command {
    private ENUM_COMMAND command;
    private ByteCode instruction;
    private Integer replace;

    public Command() {
        this.command = null;
    }

    public Command(ENUM_COMMAND _command) {
        this.command = _command;
    }

    public Command(ENUM_COMMAND _command, ByteCode _instruction) {
        this.command = _command;
        this.instruction = _instruction;
    }

    public Command(ENUM_COMMAND _command, Integer _replace) {
        this.command = _command;
        this.replace = _replace;
    }

    public boolean execute(Engine _engine) {
        try {
            switch (this.command) {
                case HELP:
                    return _engine.commandHelp();
                case QUIT:
                    return _engine.commandEnd();
                case RUN:
                    return _engine.commandRun();
                case NEWINST:
                    return _engine.commandNewinst();
                case RESET:
                    return _engine.commandReset();
                case REPLACE:
                    System.out.println();
                    return true;
                default:
                    return false;
            }
        } catch (Exception e) {
            System.out.println();
            return false;
        }

    }
}

/*
Comienza la ejecución de RUN
El estado de la maquina tras ejecutar el bytecode PUSH 2 es:
Estado de la CPU:
Memoria: <vacia>
Pila: 2
El estado de la maquina tras ejecutar el bytecode PUSH 3 es:
Estado de la CPU:
Memoria: <vacia>
Pila: 2 3
El estado de la maquina tras ejecutar el bytecode SUB es:
Estado de la CPU:
Memoria: <vacia>
Pila: -1
El estado de la maquina tras ejecutar el bytecode STORE 4 es:
Estado de la CPU:
Memoria: [4]:-1
Pila: <vacia>
Programa almacenado:
0: PUSH 2
1: PUSH 3
2: SUB
3: STORE 4
 */