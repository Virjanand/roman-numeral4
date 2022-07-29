package roman;

import java.util.*;
import java.util.stream.Collectors;

public class RomanNumber {
    private final Map<Integer, String> arabicToRomanMap;
    private int arabicNumber;

    public RomanNumber(int arabicNumber) {
        this.arabicNumber = arabicNumber;
        arabicToRomanMap = new LinkedHashMap<>();
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
        return arabicToRomanMap.entrySet().stream().map(this::extractRomanFromArabicNumber).collect(Collectors.joining());
    }

    private String extractRomanFromArabicNumber(Map.Entry<Integer, String> entry) {
        Integer number = entry.getKey();
        int timesNumberFitsInArabicNumber = arabicNumber / number;
        String result = "";
        if (arabicNumber >= 1) {
            String romanNumberString = entry.getValue();
            result += romanNumberString.repeat(timesNumberFitsInArabicNumber);
            arabicNumber -= number * timesNumberFitsInArabicNumber;
        }
        return result;
    }
}
