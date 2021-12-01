package advisor.ui.console.commands;

import advisor.entities.PlaylistCategory;
import advisor.services.AdvService;

import java.util.List;

public class CategoriesCm extends AdvCm {

    private final String name = "categories";

    public CategoriesCm(AdvService advService) {
        super(advService);
    }

    @Override
    public boolean execute(String... params) {
        List<PlaylistCategory> categories = getAdvService().getCategories();
        System.out.println("---CATEGORIES---");
        categories.forEach(System.out::println);
        return true;
    }

    @Override
    public String getName() {
        return name;
    }
}
