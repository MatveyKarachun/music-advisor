package advisor.ui.console.commands;

import advisor.entities.Album;
import advisor.services.AdvService;

import java.io.IOException;
import java.util.List;

public class NewCm extends AdvCm {

    private static final String name = "new";

    public NewCm(AdvService advService){
        super(advService);
    }

    @Override
    public boolean execute(String... params) {
        try {
            List<Album> releases = getAdvService().getNewReleases();
            System.out.println("---NEW RELEASES---");
            releases.forEach(System.out::println);
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
