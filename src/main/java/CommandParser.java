public class CommandParser {
    public static Command parse(String _line) {
        String[] particion = _line.toLowerCase().split(" ");
        switch (particion[0]) {
            case "help":
                return new Command(ENUM_COMMAND.HELP);
            case "quit":
                return new Command(ENUM_COMMAND.QUIT);
            case "run":
                return new Command(ENUM_COMMAND.RUN);
            case "reset":
                return new Command(ENUM_COMMAND.RESET);
            case "newinst":
                if (particion.length == 3) {
                    return new Command(ENUM_COMMAND.NEWINST, ByteCodeParser.parse(particion[1], particion[2]));
                } else if (particion.length == 2) {
                    return new Command(ENUM_COMMAND.NEWINST, ByteCodeParser.parse(particion[1]));
                }

            case "replace":
                return new Command(ENUM_COMMAND.REPLACE, Integer.parseInt(particion[1]));
            default:
                return new Command();
        }
    }
}
