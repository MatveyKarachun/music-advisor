package advisor.ui.console.commands;

import advisor.services.AdvService;

public class ExitCm implements Command {

    private static final String name = "exit";

    @Override
    public void execute(AdvService advService, String... params) {
        System.out.println("---GOODBYE!---");
    }

    @Override
    public String getName() {
        return name;
    }
}
