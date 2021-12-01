package advisor.ui.console.commands;

import advisor.services.AdvService;

public class AuthCm implements Command {

    private static final String name = "auth";

    @Override
    public void execute(AdvService advService, String... params) {

    }

    @Override
    public String getName() {
        return name;
    }
}
