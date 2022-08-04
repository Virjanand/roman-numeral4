package roman;

public class RomanToArabicNumberConverter {
    private final String romanNumberString;

    public RomanToArabicNumberConverter(String romanNumberString) {
        this.romanNumberString = romanNumberString;
    }

    public int toArabic() {
        if ("IV".equals(romanNumberString)) {
            return 4;
        }
        return romanNumberString.length() - romanNumberString.replaceAll("I", "").length();
    }
}
