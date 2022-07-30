package roman;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class RomanNumber {
    private final Map<Integer, String> arabicToRomanMap;
    private final int arabicNumber;

    public RomanNumber(int arabicNumber) {
        this.arabicNumber = arabicNumber;
        arabicToRomanMap = new LinkedHashMap<>();
        arabicToRomanMap.put(1000, "M");
        arabicToRomanMap.put(900, "CM");
        arabicToRomanMap.put(500, "D");
        arabicToRomanMap.put(400, "CD");
        arabicToRomanMap.put(100, "C");
        arabicToRomanMap.put(90, "XC");
        arabicToRomanMap.put(50, "L");
        arabicToRomanMap.put(40, "XL");
        arabicToRomanMap.put(10, "X");
        arabicToRomanMap.put(9, "IX");
        arabicToRomanMap.put(5, "V");
        arabicToRomanMap.put(4, "IV");
        arabicToRomanMap.put(1, "I");
    }

    public String toRoman() {
        AtomicInteger remainingNumber = new AtomicInteger(arabicNumber);
        return arabicToRomanMap.entrySet().stream().map(entry -> {
            int times = calculateTimesNumberFitsInRemainingNumber(entry.getKey(), remainingNumber.get());
            String result = repeatRomanNumber(entry.getValue(), times);
            remainingNumber.set(removeFromRemainingNumber(entry.getKey(), times, remainingNumber.get()));
            return result;
        }).collect(Collectors.joining());
    }

    private String repeatRomanNumber(String romanNumber, int times) {
        return "" + romanNumber.repeat(times);
    }

    private int removeFromRemainingNumber(Integer number, int times, int remainingNumber) {
        return remainingNumber - number * times;
    }

    private int calculateTimesNumberFitsInRemainingNumber(Integer number, int remainingNumber) {
        return remainingNumber / number;
    }
}
