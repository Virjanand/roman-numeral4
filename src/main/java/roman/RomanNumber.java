package roman;

public class RomanNumber {
    private int arabicNumber;

    public RomanNumber(int arabicNumber) {
        this.arabicNumber = arabicNumber;
    }

    public String toRoman() {
        String result = "";
        if (arabicNumber == 4) {
            result += "IV";
            arabicNumber -= 4;
        }
        if (arabicNumber >= 1) {
            result += "I".repeat(arabicNumber);
        }
        return result;
    }
}
