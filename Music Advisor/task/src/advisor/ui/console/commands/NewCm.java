package advisor.ui.console.commands;

import advisor.entities.Album;
import advisor.services.AdvService;
import advisor.ui.console.PaginationView;

import java.io.IOException;
import java.util.List;

public class NewCm extends AdvCm {

    private static final String name = "new";

    public NewCm(AdvService advService, PaginationView paginationView){
        super(advService, paginationView);
    }

    @Override
    public boolean execute(String... params) {
        List releases;
        try {
            releases = getAdvService().getNewReleases();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return false;
        }
        getPaginationView().setData(releases);
        printPage();
        return true;
    }

    @Override
    public String getName() {
        return name;
    }
}
