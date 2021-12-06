package advisor.ui.console;

import java.util.ArrayList;
import java.util.List;

public class PaginationView {

    private static int elementsOnPage = 5;
    private int index = 0;

    private List data = new ArrayList<>(0);

    public static void setElementsOnPage(int elementsOnPage) {
        PaginationView.elementsOnPage = elementsOnPage;
    }

    public void setData(List data) {
        index = 0;
        this.data = new ArrayList(data);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = index; (i < index + elementsOnPage) && (i < data.size()); i++) {
            result.append(data.get(i) + "\n");
        }
        return result.toString();
    }

    public String next() {
        if (index + elementsOnPage >= data.size()) {
            return null;
        }
        index += elementsOnPage;
        return toString();
    }

    public String prev() {
        if (index - elementsOnPage < 0) {
            return null;
        }
        index -= elementsOnPage;
        return toString();
    }

    public int currentPageNum() {
        return index / elementsOnPage + 1;
    }

    public int pagesNumber() {
        if (data.size() == 0) {
            return 0;
        }
        return (data.size() - 1) / elementsOnPage + 1;
    }
}
