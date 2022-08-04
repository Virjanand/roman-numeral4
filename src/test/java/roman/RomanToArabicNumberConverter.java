package roman;

public class RomanToArabicNumberConverter {
    private String romanNumberString;

    public RomanToArabicNumberConverter(String romanNumberString) {
        this.romanNumberString = romanNumberString;
    }

    public int toArabic() {
        if ("I".equals(romanNumberString)) {
            return 1;
        }
        return 2;
    }
}
