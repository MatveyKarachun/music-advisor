package advisor.ui.console.commands;

import advisor.entities.Playlist;
import advisor.services.AdvService;

import java.io.IOException;
import java.util.List;

public class PlaylistsCm extends AdvCm {

    private static final String name = "playlists";

    public PlaylistsCm(AdvService advService) {
        super(advService);
    }

    @Override
    public boolean execute(String... params) {
        String playlistCategoryName = "";
        if (params.length > 0) {
            playlistCategoryName = params[0];
        }
        List<Playlist> playlists = null;
        try {
            playlists = getAdvService().getPlaylistsByCategory(playlistCategoryName);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (playlists == null) {
            System.out.println("Unknown category name.");
            return false;
        } else {
            System.out.println("---" + playlistCategoryName.toUpperCase() + " PLAYLISTS---");
            playlists.forEach(System.out::println);
            return true;
        }
    }

    @Override
    public String getName() {
        return name;
    }
}
