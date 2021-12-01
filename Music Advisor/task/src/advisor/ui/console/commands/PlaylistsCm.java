package advisor.ui.console.commands;

import advisor.entities.Playlist;
import advisor.entities.PlaylistCategory;
import advisor.services.AdvService;

import java.util.List;

public class PlaylistsCm implements Command {

    private static final String name = "playlists";

    @Override
    public void execute(AdvService advService, String... params) {
        String playlistCategoryName = "";
        if (params.length > 0) {
            playlistCategoryName = params[0];
        }
        PlaylistCategory playlistCategory = new PlaylistCategory(playlistCategoryName);
        List<Playlist> playlists = advService.getPlaylistsByCategory(playlistCategory);
        System.out.println("---" + playlistCategoryName.toUpperCase() + " PLAYLISTS---");
        playlists.forEach(System.out::println);
    }

    @Override
    public String getName() {
        return name;
    }
}
