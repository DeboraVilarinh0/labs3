package numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;


public class ListAggregatorTest {

    private List<Integer> list;
    private ListAggregator aggregator;

    @BeforeEach
    public void setList() {
        list = Arrays.asList(1, 2, 4, 2, 5);

        aggregator = new ListAggregator();
    }



    @Test
    public void sum() {
        //List<Integer> list = Arrays.asList(1, 2, 4, 2, 5);
        //ListAggregator aggregator = new ListAggregator();

        int sum = aggregator.sum(list);

        Assertions.assertEquals(14, sum);
    }

    @Test
    public void max() {
        //List<Integer> list = Arrays.asList(1, 2, 4, 2, 5);
        //ListAggregator aggregator = new ListAggregator();

        int max = aggregator.max(list);

        Assertions.assertEquals(5, max);

    }

    @Test
    public void maxBug7263() {
        List<Integer> listNegatives = Arrays.asList(-1, -4, -5);
        List<Integer> newList = new ArrayList<>();

        for (Integer listNegative : listNegatives) {
            newList.add(-1 * listNegative);
        }

        int maxBug = aggregator.min(newList);

        Assertions.assertEquals(-1, -maxBug);

    }

    @Test
    public void min() {
        //List<Integer> list = Arrays.asList(1, 2, 4, 2, 5);
        //ListAggregator aggregator = new ListAggregator();

        int min = aggregator.min(list);

        Assertions.assertEquals(1, min);
    }

    @Test
    public void distinct() {
        //List<Integer> list = Arrays.asList(1, 2, 4, 2, 5);
        //ListAggregator aggregator = new ListAggregator();

        class StubListDeduplicator implements GenericListDeduplicator {
            @Override
            public List<Integer> deduplicate(List<Integer> list) {
                return Arrays.asList(1, 2, 4, 5);
            }
        }

        StubListDeduplicator deduplicator = new StubListDeduplicator();
        int distinct = aggregator.distinct(list, deduplicator);
        Assertions.assertEquals(4, distinct);
    }

    @Test
    public void distinctBug8726() {

        class StubListDeduplicator implements GenericListDeduplicator {
            @Override
            public List<Integer> deduplicate(List<Integer> list) {
                return Arrays.asList(1, 2, 4);
            }
        }

        StubListDeduplicator deduplicator = new StubListDeduplicator();
        int distinct = aggregator.distinct(list, deduplicator);
        Assertions.assertEquals(4, distinct);
    }

    @Test
    @DisplayName("Should throw an exception when the list is null")
    void distinctShouldThrowExceptionWhenTheListIsNull() {
        assertThrows(
                NullPointerException.class,
                () -> aggregator.distinct(null, new ListDeduplicator()));
    }
}
