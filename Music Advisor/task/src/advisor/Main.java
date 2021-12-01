package advisor;

import advisor.services.ServicesParams;
import advisor.ui.console.menus.EntryMenu;

import java.util.Objects;

public class Main {
    public static void main(String[] args) {

        if (args.length >= 2 && Objects.equals("-access", args[0])) {
            ServicesParams.setSpotifyServerPath(args[1]);
        }
        new EntryMenu().Enter();
    }
}
