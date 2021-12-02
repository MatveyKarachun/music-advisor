package advisor.ui.console.menus;

import advisor.services.AuthorizationServiceImpl;
import advisor.ui.console.commands.AuthCm;
import advisor.ui.console.commands.Command;
import advisor.ui.console.commands.ExitCm;

import java.util.Objects;

public class EntryMenu extends ConsoleMenu {

    private Command authCm;
    private Command exitCm;


    public EntryMenu() {
        authCm = new AuthCm(new AuthorizationServiceImpl());
        exitCm = new ExitCm();
    }

    public void Enter() {

        userWantsToExit = false;
        while (!userWantsToExit) {

            String inputCommandStr = scanner.nextLine();
            if (Objects.equals(inputCommandStr, exitCm.getName())) {
                exitCm.execute();
                userWantsToExit = true;
            } else if (Objects.equals(inputCommandStr, authCm.getName())) {
                if (authCm.execute()) {
                    new AfterAuthMenu().Enter();
                    userWantsToExit = true;
                }
            } else {
                System.out.println("Please, provide access for application.");
            }
        }
    }
}
