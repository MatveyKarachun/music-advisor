package advisor.ui.console.commands;

import advisor.ui.console.PaginationView;

public abstract class ViewCm implements Command {

    private final PaginationView paginationView;

    ViewCm(PaginationView paginationView) {
        this.paginationView = paginationView;
    }

    PaginationView getPaginationView() {
        return paginationView;
    }

    void printPage() {
        System.out.print(getPaginationView());
        System.out.println("---PAGE " + paginationView.currentPageNum()
                + " OF " + paginationView.pagesNumber() + "---");
    }
}
