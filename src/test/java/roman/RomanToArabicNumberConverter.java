package roman;

public class RomanToArabicNumberConverter {
    private String romanNumberString;

    public RomanToArabicNumberConverter(String romanNumberString) {
        this.romanNumberString = romanNumberString;
    }

    public int toArabic() {
        int result = 0;
        result += 4 * (romanNumberString.split("IV", -1).length - 1);
        romanNumberString = romanNumberString.replaceAll("IV", "");
        result += 5 * (romanNumberString.split("V", -1).length - 1);
        result += (romanNumberString.split("I", -1).length - 1);
        return result;
    }
}
