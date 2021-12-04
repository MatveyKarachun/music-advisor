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
        List<Playlist> playlists = null;
        try {
            playlists = getAdvService().getFeaturedPlaylists();
            System.out.println("---FEATURED---");
            playlists.forEach(System.out::println);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public String getName() {
        return name;
    }
}
