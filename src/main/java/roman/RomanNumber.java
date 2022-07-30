package roman;

import java.util.*;
import java.util.stream.Collectors;

public class RomanNumber {
    private final Map<Integer, String> arabicToRomanMap;
    private int arabicNumber;

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
        return arabicToRomanMap.entrySet().stream().map(entry -> {
            int times = calculateTimesNumberFitsInArabicNumber(entry.getKey());
            String result = repeatRomanNumber(entry.getValue(), times);
            removeFromArabicNumber(entry.getKey(), times);
            return result;
        }).collect(Collectors.joining());
    }

    private String repeatRomanNumber(String romanNumber, int times) {
        return "" + romanNumber.repeat(times);
    }

    private void removeFromArabicNumber(Integer number, int times) {
        arabicNumber -= number * times;
    }

    private int calculateTimesNumberFitsInArabicNumber(Integer number) {
        return arabicNumber / number;
    }
}
