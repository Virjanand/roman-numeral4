package roman;

import java.util.concurrent.atomic.AtomicInteger;

public class RomanNumber implements Comparable<RomanNumber> {
    private final int arabicNumber;
    private final String romanNumber;

    RomanNumber(int arabicNumber, String romanNumber) {
        this.arabicNumber = arabicNumber;
        this.romanNumber = romanNumber;
    }

    protected int getArabicNumber() {
        return arabicNumber;
    }

    public String extractRomanFromRemainingNumber(AtomicInteger remainingNumber) {
        int times = timesInNumber(remainingNumber.get());
        String result = repeatRomanNumber(times);
        remainingNumber.set(remainderFromNumber(remainingNumber.get()));
        return result;
    }

    public int timesInNumber(int number) {
        return number / this.arabicNumber;
    }

    public String repeatRomanNumber(int times) {
        return "" + this.romanNumber.repeat(times);
    }

    public int remainderFromNumber(int number) {
        return number % this.arabicNumber;
    }

    @Override
    public int compareTo(RomanNumber other) {
        return Integer.compare(this.arabicNumber, other.getArabicNumber());
    }
}
