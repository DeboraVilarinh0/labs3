package numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PositiveFilterTest {
    PositiveFilter positiveFilter = new PositiveFilter();

    @Test
    void testAccept() {
        boolean result = positiveFilter.accept(0);
        Assertions.assertTrue(result);
    }

    @Test
    void testAcceptFail() {
        boolean result = positiveFilter.accept(-1);
        Assertions.assertFalse(result);
    }

}
