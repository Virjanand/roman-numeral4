package roman;

public class RomanToArabicNumberConverter {
    private String romanNumberString;

    public RomanToArabicNumberConverter(String romanNumberString) {
        this.romanNumberString = romanNumberString;
    }

    public int toArabic() {
        int result = 0;
        result += countAmountFrom("IV", 4);
        result += countAmountFrom("V", 5);
        result += countAmountFrom("I", 1);
        return result;
    }

    private int countAmountFrom(String romanNumberPart, int arabicValue) {
        int result = arabicValue * (romanNumberString.split(romanNumberPart, -1).length - 1);
        romanNumberString = romanNumberString.replaceAll(romanNumberPart, "");
        return result;
    }
}
