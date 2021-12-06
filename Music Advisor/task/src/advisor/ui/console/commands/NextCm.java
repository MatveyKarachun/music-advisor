package advisor.ui.console.commands;

import advisor.ui.console.PaginationView;

public class NextCm extends ViewCm {

    private static final String name = "next";

    public NextCm(PaginationView paginationView) {
        super(paginationView);
    }

    @Override
    public boolean execute(String... params) {
        if (getPaginationView().next() == null) {
            System.out.println("No more pages");
            return false;
        }
        printPage();
        return true;
    }

    @Override
    public String getName() {
        return name;
    }
}
