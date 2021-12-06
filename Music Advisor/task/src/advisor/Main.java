package advisor;

import advisor.services.AbstractService;
import advisor.ui.console.PaginationView;
import advisor.ui.console.menus.EntryMenu;

public class Main {
    public static void main(String[] args) {

        for (int i = 0; i < args.length - 1; i++) {
            switch (args[i]) {
                case "-access":
                    AbstractService.setAuthorizationServerPath(args[++i]);
                    break;
                case "-resource":
                    AbstractService.setApiServerPath(args[++i]);
                    break;
                case "-page":
                    PaginationView.setElementsOnPage(Integer.valueOf(args[++i]));
                    break;
            }
        }
        new EntryMenu().Enter();
    }
}
