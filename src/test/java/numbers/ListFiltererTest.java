package numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.*;

class ListFiltererTest {
    @Mock
    GenericListFilter filter;
    @InjectMocks
    ListFilterer listFilterer;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFilter() {


        List<Double> listNumbers = new LinkedList<>();

        int min;
        int max;
        double numbers = 0;

        for (int i = 1; i <= 5; i++) {
            max = 10;
            min = -10;
            int range = max - min + 1;
            numbers = Math.floor(Math.random() * range) + min;
            listNumbers.add(numbers);
        }


        for (Double listNumber : listNumbers) {
            if (listNumber >= 0) {
                when(filter.accept(anyInt())).thenReturn(true);
                List<Integer> resultPositive = listFilterer.filter(Arrays.asList(0, 1, 2, 3));
                Assertions.assertEquals(Arrays.asList(0, 1, 2, 3), resultPositive);

            } else if (listNumber < 0) {
                when(filter.accept(anyInt())).thenReturn(false);
                List<Integer> resultNegative = listFilterer.filter(Collections.emptyList());
                Assertions.assertEquals(Collections.emptyList(), resultNegative);

            }
        }


    }
}

