package advisor.ui.console.commands;

import advisor.entities.Playlist;
import advisor.services.AdvService;

import java.io.IOException;
import java.util.List;

public class FeaturedCm extends AdvCm {

    private static final String name = "featured";

    public FeaturedCm(AdvService advService) {
        super(advService);
    }

    @Override
    public boolean execute(String... params) {
        List<Playlist> playlists;
        try {
            playlists = getAdvService().getFeaturedPlaylists();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return false;
        }
        playlists.forEach(System.out::println);
        return true;
    }

    @Override
    public String getName() {
        return name;
    }
}
