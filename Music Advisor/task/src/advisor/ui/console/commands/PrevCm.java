package advisor.ui.console.commands;

import advisor.ui.console.PaginationView;

public class PrevCm extends ViewCm {

    private static final String name = "prev";

    public PrevCm(PaginationView paginationView) {
        super(paginationView);
    }

    @Override
    public boolean execute(String... params) {
        if (getPaginationView().prev() == null) {
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
