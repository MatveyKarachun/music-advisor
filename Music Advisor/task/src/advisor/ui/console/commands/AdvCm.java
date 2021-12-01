package advisor.ui.console.commands;

import advisor.services.AdvService;

public abstract class AdvCm implements Command {

    private final AdvService advService;

    AdvCm(AdvService advService){
        this.advService = advService;
    }

    AdvService getAdvService() {
        return advService;
    }
}
