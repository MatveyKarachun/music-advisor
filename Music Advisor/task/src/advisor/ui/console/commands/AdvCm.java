package advisor.ui.console.commands;

import advisor.services.AdvService;
import advisor.ui.console.PaginationView;

public abstract class AdvCm extends ViewCm {

    private final AdvService advService;

    AdvCm(AdvService advService, PaginationView paginationView){
        super(paginationView);
        this.advService = advService;
    }

    AdvService getAdvService() {
        return advService;
    }
}
