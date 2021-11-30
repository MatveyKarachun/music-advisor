package advisor.ui.console.commands;

import advisor.services.AdvService;

abstract class Command {

    private final String name;

    Command(String name) {
        this.name = name;
    }

    public abstract void execute(AdvService advService);

    public String getName() {
        return name;
    }
}
