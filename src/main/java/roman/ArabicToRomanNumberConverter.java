package roman;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class ArabicToRomanNumberConverter {
    private final int arabicNumber;
    private final List<RomanNumber> romanNumbers;

    public ArabicToRomanNumberConverter(int arabicNumber) {
        this.arabicNumber = arabicNumber;

        romanNumbers = new ArrayList<>();
        romanNumbers.add(new RomanNumber(1000, "M"));
        romanNumbers.add(new RomanNumber(900, "CM"));
        romanNumbers.add(new RomanNumber(500, "D"));
        romanNumbers.add(new RomanNumber(400, "CD"));
        romanNumbers.add(new RomanNumber(100, "C"));
        romanNumbers.add(new RomanNumber(90, "XC"));
        romanNumbers.add(new RomanNumber(50, "L"));
        romanNumbers.add(new RomanNumber(40, "XL"));
        romanNumbers.add(new RomanNumber(10, "X"));
        romanNumbers.add(new RomanNumber(9, "IX"));
        romanNumbers.add(new RomanNumber(5, "V"));
        romanNumbers.add(new RomanNumber(4, "IV"));
        romanNumbers.add(new RomanNumber(1, "I"));
    }

    public String toRoman() {
        AtomicInteger remainingNumber = new AtomicInteger(arabicNumber);
        return romanNumbers.stream().sorted(Comparator.reverseOrder()).map(roman -> extractRomanFromRemainingNumber(remainingNumber, roman))
                .collect(Collectors.joining());
    }

    private String extractRomanFromRemainingNumber(AtomicInteger remainingNumber, RomanNumber roman) {
        int times = roman.timesInNumber(remainingNumber.get());
        String result = roman.repeatRomanNumber(times);
        remainingNumber.set(roman.remainderFromNumber(remainingNumber.get()));
        return result;
    }
}
