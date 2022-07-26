package roman;

public class RomanNumber {
    private final int arabicNumber;

    public RomanNumber(int arabicNumber) {
        this.arabicNumber = arabicNumber;
    }

    public String toRoman() {
        String result = "";
        if (arabicNumber == 1) {
            result += "I";
        }
        if (arabicNumber == 2) {
            result += "II";
        }
        return result;
    }
}
