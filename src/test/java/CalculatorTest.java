import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorTest {

    @ParameterizedTest
    @MethodSource("divisionTestingMethod")
    void testDivision(double dividend, double divisor, double expected) {
        assertEquals(expected, Calculator.divide(dividend, divisor));
    }

    static Stream<Arguments> divisionTestingMethod() {
        return Stream.of(
                Arguments.of(10, 2, 5),
                Arguments.of(10, 4, 2.5),
                Arguments.of(12.5, 5, 2.5),
                Arguments.of(10, 2.5, 4),
                Arguments.of(12.5, 2.5, 5)
        );
    }

    @Test
    void testDivisionByZero() {
        assertThrows(IllegalArgumentException.class, () -> Calculator.divide(12.5, 0), "IllegalArgumentException expected.");
    }
}
