package roman;

public class RomanNumber {
    private int arabicNumber;

    public RomanNumber(int arabicNumber) {
        this.arabicNumber = arabicNumber;
    }

    public String toRoman() {
        String result = "";
        result += extractRomanFromArabicNumber(5, "V");
        result += extractRomanFromArabicNumber(4, "IV");
        result += extractRomanFromArabicNumber(1, "I");
        return result;
    }

    private String extractRomanFromArabicNumber(int arabicNumber, String romanNumberString) {
        int timesNumberFitsInArabicNumber = this.arabicNumber / arabicNumber;
        String result = "";
        if (this.arabicNumber >= 1) {
            result += romanNumberString.repeat(timesNumberFitsInArabicNumber);
            this.arabicNumber -= this.arabicNumber * timesNumberFitsInArabicNumber;
        }
        return result;
    }
}
