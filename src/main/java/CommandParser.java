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
                return new Command(ENUM_COMMAND.NEWINST, ByteCodeParser.parse(particion[1]));
            case "replace":
                return new Command(ENUM_COMMAND.REPLACE, ByteCodeParser.parse(particion[1]), Integer.parseInt(particion[2]));
        }
        return null;
    }
}
