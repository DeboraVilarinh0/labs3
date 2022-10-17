package numbers;

import java.util.ArrayList;
import java.util.List;

public class ListFilterer {

    private final GenericListFilter filter;

    public ListFilterer(GenericListFilter filter) {
        this.filter = filter;
    }

    public List<Integer> filter(List<Integer> list) {

        List<Integer> finalList = new ArrayList<>();

        for (Integer integer : list) {
            if (filter.accept(integer)) {
                finalList.add(integer);
            }
        }

        return finalList;
    }

}
