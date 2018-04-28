package campusRecycle.util;

import java.util.Iterator;

public class Page<T> implements Iterable<T> {
    Pageable<T> pageable;
    int pageNumber;

    Page(Pageable<T> pageable, int pageNumber) {
        this.pageable = pageable;
        this.pageNumber = pageNumber;
    }

    @Override
    public Iterator<T> iterator() {
        return pageable.getPageList(pageNumber).iterator();
    }
}
