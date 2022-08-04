package roman;

public class RomanToArabicNumberConverter {
    private final String romanNumberString;

    public RomanToArabicNumberConverter(String romanNumberString) {
        this.romanNumberString = romanNumberString;
    }

    public int toArabic() {
        return romanNumberString.length() - romanNumberString.replaceAll("I", "").length();
    }
}
