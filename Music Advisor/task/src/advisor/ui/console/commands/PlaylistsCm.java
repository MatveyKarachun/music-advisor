package advisor.ui.console.commands;

import advisor.entities.Playlist;
import advisor.services.AdvService;
import advisor.services.JsonHasErrorMessageException;
import advisor.ui.console.PaginationView;

import java.io.IOException;
import java.util.List;

public class PlaylistsCm extends AdvCm {

    private static final String name = "playlists";

    public PlaylistsCm(AdvService advService, PaginationView paginationView) {
        super(advService, paginationView);
    }

    @Override
    public boolean execute(String... params) {
        String playlistCategoryName = "";
        if (params.length > 0) {
            playlistCategoryName = params[0];
        }
        List playlists;
        try {
            playlists = getAdvService().getPlaylistsByCategory(playlistCategoryName);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return false;
        } catch (JsonHasErrorMessageException e) {
            System.out.println(e.getMessage());
            return false;
        }
        if (playlists == null) {
            System.out.println("Unknown category name.");
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
