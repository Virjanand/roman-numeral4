package roman;

import java.util.ArrayList;
import java.util.List;

public class RomanToArabicNumberConverter {
    private final List<RomanNumber> romanNumbers;
    private String romanNumberString;

    public RomanToArabicNumberConverter(String romanNumberString) {
        this.romanNumberString = romanNumberString;
        romanNumbers = new ArrayList<>();
        romanNumbers.add(new RomanNumber(900, "CM"));
        romanNumbers.add(new RomanNumber(1000, "M"));
        romanNumbers.add(new RomanNumber(400, "CD"));
        romanNumbers.add(new RomanNumber(500, "D"));
        romanNumbers.add(new RomanNumber(90, "XC"));
        romanNumbers.add(new RomanNumber(100, "C"));
        romanNumbers.add(new RomanNumber(40, "XL"));
        romanNumbers.add(new RomanNumber(50, "L"));
        romanNumbers.add(new RomanNumber(9, "IX"));
        romanNumbers.add(new RomanNumber(10, "X"));
        romanNumbers.add(new RomanNumber(4, "IV"));
        romanNumbers.add(new RomanNumber(5, "V"));
        romanNumbers.add(new RomanNumber(1, "I"));
    }

    public int toArabic() {
        return romanNumbers.stream().mapToInt(roman -> countAmountFrom(roman.getRomanNumber(), roman.getArabicNumber())).sum();
    }

    private int countAmountFrom(String romanNumberPart, int arabicValue) {
        int result = arabicValue * countOccurrences(romanNumberPart);
        romanNumberString = romanNumberString.replaceAll(romanNumberPart, "");
        return result;
    }

    private int countOccurrences(String romanNumberPart) {
        return romanNumberString.split(romanNumberPart, -1).length - 1;
    }
}
