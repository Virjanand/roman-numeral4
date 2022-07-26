package roman;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RomanNumeralTest {

    @Test
    void convert1ToI() {
        RomanNumber romanNumber = new RomanNumber(1);
        assertThat(romanNumber.toRoman()).isEqualTo("I");
    }

    @Test
    void convert2ToII() {
        RomanNumber romanNumber = new RomanNumber(2);
        assertThat(romanNumber.toRoman()).isEqualTo("II");
    }
}
