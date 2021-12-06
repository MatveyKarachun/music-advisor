package advisor.ui.console.commands;


import advisor.services.AdvService;
import advisor.ui.console.PaginationView;

import java.io.IOException;
import java.util.List;

public class CategoriesCm extends AdvCm {

    private final String name = "categories";

    public CategoriesCm(AdvService advService, PaginationView paginationView) {
        super(advService, paginationView);
    }

    @Override
    public boolean execute(String... params) {
        List categories;
        try {
            categories = getAdvService().getCategories();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return false;
        }
        getPaginationView().setData(categories);
        printPage();
        return true;
    }

    @Override
    public String getName() {
        return name;
    }
}
