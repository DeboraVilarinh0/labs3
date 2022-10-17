package numbers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DivisibleByFilterTest {

    @Test
    @DisplayName("Should return true when the number is divisible by the divisor")
    void acceptWhenNumberIsDivisibleByDivisorThenReturnTrue() {
        DivisibleByFilter divisibleByFilter = new DivisibleByFilter(2);
        boolean result = divisibleByFilter.accept(4);
        assertTrue(result);
    }

    @Test
    @DisplayName("Should throw an exception when the divisor is 0")
    void acceptWhenDivisorIsZeroThenThrowException() {
        DivisibleByFilter divisibleByFilter = new DivisibleByFilter(0);
        assertThrows(IllegalArgumentException.class, () -> divisibleByFilter.accept(1));
    }

    @Test
    @DisplayName("Should return false when the number is not divisible by the divisor")
    void acceptWhenNumberIsNotDivisibleByDivisorThenReturnFalse() {
        DivisibleByFilter divisibleByFilter = new DivisibleByFilter(3);
        boolean result = divisibleByFilter.accept(5);
        assertFalse(result);
    }

    @Test
    public void testAcceptTrue() {
        DivisibleByFilter divisibleByFilter = new DivisibleByFilter(2);
        assertTrue(divisibleByFilter.accept(10));
    }

    @Test
    public void testAcceptFalse() {
        DivisibleByFilter divisibleByFilter = new DivisibleByFilter(2);
        assertFalse(divisibleByFilter.accept(1));
    }
}

