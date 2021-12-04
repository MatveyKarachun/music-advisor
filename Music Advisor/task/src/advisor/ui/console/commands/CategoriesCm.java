package advisor.ui.console.commands;


import advisor.services.AdvService;

import java.io.IOException;
import java.util.List;

public class CategoriesCm extends AdvCm {

    private final String name = "categories";

    public CategoriesCm(AdvService advService) {
        super(advService);
    }

    @Override
    public boolean execute(String... params) {
        List<String> categories = null;
        try {
            categories = getAdvService().getCategories();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        categories.forEach(System.out::println);
        return true;
    }

    @Override
    public String getName() {
        return name;
    }
}
