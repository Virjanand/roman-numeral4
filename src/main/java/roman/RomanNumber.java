package roman;

public class RomanNumber implements Comparable<RomanNumber> {
    private final int arabicNumber;
    private final String romanNumber;

    RomanNumber(int arabicNumber, String romanNumber) {
        this.arabicNumber = arabicNumber;
        this.romanNumber = romanNumber;
    }

    private int getArabicNumber() {
        return arabicNumber;
    }

    public int timesInNumber(int number) {
        return number / arabicNumber;
    }

    public String repeatRomanNumber(int times) {
        return romanNumber.repeat(times);
    }

    public int remainderFromNumber(int number) {
        return number % arabicNumber;
    }

    @Override
    public int compareTo(RomanNumber other) {
        return Integer.compare(arabicNumber, other.getArabicNumber());
    }
}
