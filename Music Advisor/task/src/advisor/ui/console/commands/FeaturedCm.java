package advisor.ui.console.commands;

import advisor.entities.Playlist;
import advisor.services.AdvService;

import java.util.List;

public class FeaturedCm extends AdvCm {

    private static final String name = "featured";

    public FeaturedCm(AdvService advService) {
        super(advService);
    }

    @Override
    public boolean execute(String... params) {
        List<Playlist> playlists = getAdvService().getFeaturedPlaylists();
        System.out.println("---FEATURED---");
        playlists.forEach(System.out::println);
        return true;
    }

    @Override
    public String getName() {
        return name;
    }
}
