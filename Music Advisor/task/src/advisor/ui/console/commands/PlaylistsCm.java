package advisor.ui.console.commands;

import advisor.entities.Playlist;
import advisor.entities.PlaylistCategory;
import advisor.services.AdvService;

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
        PlaylistCategory playlistCategory = new PlaylistCategory(playlistCategoryName);
        List<Playlist> playlists = getAdvService().getPlaylistsByCategory(playlistCategory);
        System.out.println("---" + playlistCategoryName.toUpperCase() + " PLAYLISTS---");
        playlists.forEach(System.out::println);
        return true;
    }

    @Override
    public String getName() {
        return name;
    }
}
