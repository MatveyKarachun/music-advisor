package advisor;

import advisor.services.AbstractService;
import advisor.ui.console.menus.EntryMenu;

public class Main {
    public static void main(String[] args) {

        for (int i = 0; i < args.length - 1; i++) {
            if ("-access".equals(args[i])) {
                AbstractService.setAuthorizationServerPath(args[++i]);
            } else if ("-resource".equals(args[i])) {
                AbstractService.setApiServerPath(args[++i]);
            }
        }

        new EntryMenu().Enter();
    }
}
