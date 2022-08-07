package roman;

import java.util.ArrayList;
import java.util.List;

public class RomanToArabicNumberConverter {
    private final List<RomanNumber> romanNumbers;
    private String romanNumberString;

    public RomanToArabicNumberConverter(String romanNumberString) {
        this.romanNumberString = romanNumberString;
        romanNumbers = new ArrayList<>();
        romanNumbers.add(new RomanNumber(4, "IV"));
        romanNumbers.add(new RomanNumber(5, "V"));
        romanNumbers.add(new RomanNumber(1, "I"));
    }

    public int toArabic() {
        return romanNumbers.stream().mapToInt(roman -> countAmountFrom(roman.getRomanNumber(), roman.getArabicNumber())).sum();
    }

    private int countAmountFrom(String romanNumberPart, int arabicValue) {
        int result = arabicValue * (romanNumberString.split(romanNumberPart, -1).length - 1);
        romanNumberString = romanNumberString.replaceAll(romanNumberPart, "");
        return result;
    }
}
