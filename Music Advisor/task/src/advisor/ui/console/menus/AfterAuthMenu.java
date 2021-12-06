package advisor.ui.console.menus;

import advisor.services.AdvService;
import advisor.ui.console.PaginationView;
import advisor.ui.console.commands.*;

import java.util.List;

class AfterAuthMenu extends ConsoleMenu {

    private final Iterable<Command> availableCommands;
    private final PaginationView paginationView;

    AfterAuthMenu(AdvService advService) {
        paginationView = new PaginationView();
        availableCommands = List.of(new CategoriesCm(advService, paginationView),
                new FeaturedCm(advService, paginationView),
                new NewCm(advService, paginationView),
                new PlaylistsCm(advService, paginationView),
                new NextCm(paginationView),
                new PrevCm(paginationView),
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
