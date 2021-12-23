import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTests {
    private ArrayList<Double> numbers = new ArrayList<>(Arrays.asList(39.2, 0.0, 36.6));
    private ArrayList<String> degree = new ArrayList<>(Arrays.asList("-C", "-F", "-K"));

    @Test
    public void checkCorrectConvertFromKelvin() {
        assertEquals(DegreeConverterApplication.convertFromKelvin(numbers, degree).get(0), "Result: -233,95°C");
        assertEquals(DegreeConverterApplication.convertFromKelvin(numbers, degree).get(3), "Result: -389,11°F");
        assertEquals(DegreeConverterApplication.convertFromKelvin(numbers, degree).get(6), "I don't understand why you need this, but the result is: 39.2°K");
    }

    @Test
    public void checkCorrectConvertFromCelsius() {
        assertEquals(DegreeConverterApplication.convertFromCelsius(numbers, degree).get(1), "I don't understand why you need this, but the result is: 0.0°C");
        assertEquals(DegreeConverterApplication.convertFromCelsius(numbers, degree).get(4), "Result: 32,00°F");
        assertEquals(DegreeConverterApplication.convertFromCelsius(numbers, degree).get(7), "Result: 273,15°K");
    }

    @Test
    public void checkCorrectConvertFromFahrenheit() {
        assertEquals(DegreeConverterApplication.convertFromFahrenheit(numbers, degree).get(2), "Result: 2,56°C");
        assertEquals(DegreeConverterApplication.convertFromFahrenheit(numbers, degree).get(5), "I don't understand why you need this, but the result is: 36.6°F");
        assertEquals(DegreeConverterApplication.convertFromFahrenheit(numbers, degree).get(8), "Result: 275,71°K");
    }
}
