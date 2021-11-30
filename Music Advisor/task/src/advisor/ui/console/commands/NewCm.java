package advisor.ui.console.commands;

import advisor.services.AdvService;

import java.util.List;

public class NewCm extends Command {

    public NewCm() {
        super("new");
    }

    @Override
    public void execute(AdvService advService) {
         advService.getNewReleases();
    }
}
