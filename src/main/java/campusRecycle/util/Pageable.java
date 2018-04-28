package campusRecycle.util;

import javax.validation.constraints.Min;
import java.util.ArrayList;
import java.util.List;

public class Pageable<T> {

    Iterable<T> collection;
    @Min(1)
    int itemsPerPage = 3; // TODO
    List<List<T>> pages = new ArrayList<>();

    public Pageable(Iterable<T> collection) {
        this.collection = collection;
        repaginate();
    }

    void repaginate() {
        int itemsInCurrentPage = 0;
        pages = new ArrayList<>();
        List<T> newPage = new ArrayList<>(itemsPerPage);
        for (T x : collection) {
            if (itemsInCurrentPage == itemsPerPage) {
                pages.add(newPage);
                newPage = new ArrayList<>(itemsPerPage);
                itemsInCurrentPage = 0;
            }
            newPage.add(x);
            itemsInCurrentPage += 1;
        }
        if (!newPage.isEmpty()) pages.add(newPage);
    }

    public int getNumPages() {
        return pages.size();
    }

    public Page<T> getPage(int pageIndex) {
        return new Page<>(this, pageIndex);
    }

    public boolean isEmpty() {
        return pages.size() == 0;
    }

    List<T> getPageList(int pageIndex) {
        try {
            return pages.get(pageIndex);
        } catch (IndexOutOfBoundsException e) {
            return new ArrayList<>(itemsPerPage);
        }
    }
}
