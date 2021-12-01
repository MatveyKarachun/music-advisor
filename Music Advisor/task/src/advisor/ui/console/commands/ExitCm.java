package advisor.ui.console.commands;

public class ExitCm implements Command {

    private static final String name = "exit";

    @Override
    public boolean execute(String... params) {
        System.out.println("---GOODBYE!---");
        return true;
    }

    @Override
    public String getName() {
        return name;
    }
}
