package advisor.ui.console.commands;

import advisor.entities.Playlist;
import advisor.services.AdvService;
import advisor.ui.console.PaginationView;

import java.io.IOException;
import java.util.List;

public class FeaturedCm extends AdvCm {

    private static final String name = "featured";

    public FeaturedCm(AdvService advService, PaginationView paginationView) {
        super(advService, paginationView);
    }

    @Override
    public boolean execute(String... params) {
        List playlists;
        try {
            playlists = getAdvService().getFeaturedPlaylists();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return false;
        }
        getPaginationView().setData(playlists);
        printPage();
        return true;
    }

    @Override
    public String getName() {
        return name;
    }
}
