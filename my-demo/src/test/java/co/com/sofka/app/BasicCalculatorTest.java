package co.com.sofka.app;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BasicCalculatorTest {

    private final BasicCalculator basicCalculator = new BasicCalculator();

    @Test
    @DisplayName("Testing sum: 1+1=2")
    public void sum() {
        // Arrange
        Long number1 = 1L;
        Long number2 = 1L;
        Long expectedValue = 2L;

        // Act
        Long result = basicCalculator.sum(number1, number2);

        // Assert
        assertEquals(expectedValue, result);
    }

    @DisplayName("Testing several sums")
    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource({
            "0,    1,   1",
            "1,    2,   3",
            "49,  51, 100",
            "1,  100, 101"
    })
    public void severalSums(Long first, Long second, Long expectedResult) {
        assertEquals(expectedResult, basicCalculator.sum(first, second),
                () -> first + " + " + second + " should equal " + expectedResult);
    }

    @Test
    @DisplayName("Testing subtract: 1-1=0")
    public void subtract() {
        // Arrange
        Long number1 = 1L;
        Long number2 = 1L;
        Long expectedValue = 0L;

        // Act
        Long result = basicCalculator.subtract(number1, number2);

        // Assert
        assertEquals(expectedValue, result);
    }

    @Test
    @DisplayName("Testing mul: 3*2=6")
    void mul() {
        // Arrange
        Long number1 = 3L;
        Long number2 = 2L;
        Long expectedValue = 6L;

        // Act
        Long result = basicCalculator.multiply(number1, number2);

        // Assert
        assertEquals(expectedValue, result);
    }

    @DisplayName("Testing several muls")
    @ParameterizedTest(name = "{0} * {1} = {2}")
    @CsvSource({
            "0,    1,   0",
            "1,    2,   2",
            "49,  51, 2499",
            "1,  100, 100"
    })
    public void severalMuls(Long first, Long second, Long expectedResult) {
        assertEquals(expectedResult, basicCalculator.multiply(first, second),
                () -> first + " * " + second + " should equal " + expectedResult);
    }

    @Test
    @DisplayName("Testing div: 6/2=3")
    void div() {
        // Arrange
        Double number1 = 6D;
        Double number2 = 2D;
        Double expectedValue = 3D;

        // Act
        Double result = basicCalculator.divide(number1, number2);

        // Assert
        assertEquals(expectedValue, result);
    }

    @DisplayName("Testing several divs")
    @ParameterizedTest(name = "{0} / {1} = {2}")
    @CsvSource({
            "0,    1,   0",
            "1,    2,   0.5",
            "75,  3, 25",
            "5,  2, 2.5"
    })
    public void severalDivs(Double first, Double second, Double expectedResult) {
        assertEquals(expectedResult, basicCalculator.divide(first, second),
                () -> first + " / " + second + " should equal " + expectedResult);
    }

}
