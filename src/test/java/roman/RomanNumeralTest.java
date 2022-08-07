package roman;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RomanNumeralTest {

    @ParameterizedTest(name = "{0} -> {1}")
    @CsvSource({
            "1, I",
            "2, II",
            "4, IV",
            "5, V",
            "6, VI",
            "9, IX",
            "10, X",
            "40, XL",
            "50, L",
            "90, XC",
            "101, CI",
            "400, CD",
            "500, D",
            "900, CM",
            "1000, M",
            "1984, MCMLXXXIV",
    })
    void convertArabicToRomanNumber(int arabicNumber, String romanNumberString) {
        ArabicToRomanNumberConverter arabicToRomanNumberConverter = new ArabicToRomanNumberConverter(arabicNumber);
        assertThat(arabicToRomanNumberConverter.toRoman()).isEqualTo(romanNumberString);
    }

    @ParameterizedTest(name = "{0} -> {1}")
    @CsvSource({
            "I, 1",
            "II, 2",
            "IV, 4",
            "V, 5",
            "IX, 9",
            "X, 10",
            "XL, 40",
            "L, 50",
            "XC, 90",
            "CI, 101",
            "CD, 400",
            "D, 500",
            "CM, 900",
            "M, 1000",
            "MCMLXXXIV, 1984",
    })
    void convertRomanToArabicNumber(String romanNumberString, int arabicNumber) {
        RomanToArabicNumberConverter arabicToRomanNumberConverter = new RomanToArabicNumberConverter(romanNumberString);
        assertThat(arabicToRomanNumberConverter.toArabic()).isEqualTo(arabicNumber);
    }
}
