package advisor.ui.console.commands;

import advisor.entities.Album;
import advisor.services.AdvService;

import java.util.List;

public class NewCm implements Command {

    private static final String name = "new";

    @Override
    public void execute(AdvService advService, String... params) {
        List<Album> releases = advService.getNewReleases();
        System.out.println("---NEW RELEASES---");
        releases.forEach(System.out::println);
    }

    @Override
    public String getName() {
        return name;
    }
}
