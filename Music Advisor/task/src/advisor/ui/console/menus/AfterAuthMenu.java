package advisor.ui.console.menus;

import advisor.services.AdvService;
import advisor.services.AdvServiceMockImpl;
import advisor.ui.console.commands.*;

import java.util.List;

class AfterAuthMenu extends ConsoleMenu {

    private final AdvService advService;
    private final Iterable<Command> availableCommands;

    AfterAuthMenu(AdvService advService) {
        this.advService = advService;
        availableCommands = List.of(new CategoriesCm(advService),
                new FeaturedCm(advService),
                new NewCm(advService),
                new PlaylistsCm(advService),
                new ExitCm());
    }

    void Enter() {
        userWantsToExit = false;
        while (!userWantsToExit) {

            String[] commandAndArg = scanner.nextLine()
                    .trim()
                    .split("\\s+", 2);

            availableCommands.forEach(c -> {
                if (c.nameIs(commandAndArg[0])) {
                    if (commandAndArg.length >= 2) {
                        c.execute(commandAndArg[1]);
                    } else {
                        c.execute();
                    }
                    if (c.nameIs("exit")) {
                        userWantsToExit = true;
                    }
                }
            });
        }
    }
}
