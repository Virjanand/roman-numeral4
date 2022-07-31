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
        int times = calculateTimesNumberFitsInRemainingNumber(remainingNumber.get());
        String result = repeatRomanNumber(times);
        remainingNumber.set(removeFromRemainingNumber(remainingNumber.get(), times));
        return result;
    }

    private int calculateTimesNumberFitsInRemainingNumber(int remainingNumber) {
        return remainingNumber / this.arabicNumber;
    }

    private String repeatRomanNumber(int times) {
        return "" + this.romanNumber.repeat(times);
    }

    private int removeFromRemainingNumber(int remainingNumber, int times) {
        return remainingNumber - this.arabicNumber * times;
    }

    @Override
    public int compareTo(RomanNumber other) {
        return Integer.compare(this.arabicNumber, other.getArabicNumber());
    }
}
