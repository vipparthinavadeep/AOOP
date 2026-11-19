import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Currency;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

// Immutable Money class
final class Money implements Comparable<Money> {

    private final long minor;
    private final Currency currency;

    // Constructor
    private Money(long minor, Currency currency) {

        this.minor = minor;
        this.currency = Objects.requireNonNull(currency);
    }

    // Create Money object
    public static Money ofMinor(String currencyCode, long minorUnits) {

        return new Money(
            minorUnits,
            Currency.getInstance(currencyCode)
        );
    }

    // Addition
    public Money add(Money other) {

        requireSameCurrency(other);

        return new Money(
            Math.addExact(minor, other.minor),
            currency
        );
    }

    // Subtraction
    public Money subtract(Money other) {

        requireSameCurrency(other);

        return new Money(
            Math.subtractExact(minor, other.minor),
            currency
        );
    }

    // Multiplication
    public Money times(long factor) {

        return new Money(
            Math.multiplyExact(minor, factor),
            currency
        );
    }

    // Percentage calculation
    public Money percentage(int percent, RoundingMode mode) {

        long result = BigDecimal.valueOf(minor)
            .multiply(BigDecimal.valueOf(percent))
            .divide(BigDecimal.valueOf(100), 0, mode)
            .longValueExact();

        return new Money(result, currency);
    }

    // Divide money into equal parts
    public List<Money> allocate(int parts) {

        if (parts <= 0)
            throw new IllegalArgumentException(
                "parts must be positive"
            );

        if (minor < 0)
            throw new IllegalArgumentException(
                "cannot allocate a negative amount"
            );

        long base = minor / parts;
        long remainder = minor % parts;

        List<Money> result = new ArrayList<>();

        for (int i = 0; i < parts; i++) {

            result.add(
                new Money(
                    base + (i < remainder ? 1 : 0),
                    currency
                )
            );
        }

        return List.copyOf(result);
    }

    // Check currency
    private void requireSameCurrency(Money other) {

        if (!currency.equals(other.currency)) {

            throw new IllegalArgumentException(
                "Currency mismatch: " +
                currency + " vs " + other.currency
            );
        }
    }

    // Compare money
    @Override
    public int compareTo(Money other) {

        requireSameCurrency(other);

        return Long.compare(minor, other.minor);
    }

    // Equality
    @Override
    public boolean equals(Object o) {

        return o instanceof Money m &&
            minor == m.minor &&
            currency.equals(m.currency);
    }

    // HashCode
    @Override
    public int hashCode() {

        return Objects.hash(minor, currency);
    }

    // Display money
    @Override
    public String toString() {

        BigDecimal shown = BigDecimal.valueOf(
            minor,
            currency.getDefaultFractionDigits()
        );

        return currency.getCurrencyCode() +
            " " + shown.toPlainString();
    }
    
}


// Main class
public class MoneyDemo {

    public static void main(String[] args) {

        Money a = Money.ofMinor("INR", 10050);

        Money b = Money.ofMinor("INR", 10050);

        System.out.println("a = " + a);

        System.out.println("a == b      : " + (a == b));

        System.out.println("a.equals(b) : " + a.equals(b));

        Set<Money> set = new HashSet<>();

        set.add(a);
        set.add(b);

        System.out.println("set size    : " + set.size());

        // Addition
        Money sum = a.add(
            Money.ofMinor("INR", 2575)
        );

        System.out.println(
            "sum = " + sum + ", a still = " + a
        );

        // Currency mismatch
        try {

            a.add(Money.ofMinor("USD", 100));

        } catch (IllegalArgumentException e) {

            System.out.println("Rejected: " + e.getMessage());
        }

        // GST calculation
        System.out.println(
            "GST 18% on INR 9.99: " +
            Money.ofMinor("INR", 999)
                .percentage(18, RoundingMode.HALF_UP)
        );

        // Allocation
        List<Money> parts =
            Money.ofMinor("INR", 10000).allocate(3);

        System.out.println("split in 3: " + parts);

        Money total = parts.stream().reduce(
            Money.ofMinor("INR", 0),
            Money::add
        );

        System.out.println("sum of parts: " + total);

        // Different currencies
        System.out.println(Money.ofMinor("JPY", 500));

        System.out.println(Money.ofMinor("KWD", 1500));

        // Comparison
        Money five = Money.ofMinor("INR", 500);

        Money seven = Money.ofMinor("INR", 700);

        System.out.println(
            five + " < " + seven + " : " +
            (five.compareTo(seven) < 0)
        );

        // Overflow detection
        try {

            Money.ofMinor("INR", Long.MAX_VALUE)
                .add(Money.ofMinor("INR", 1));

        } catch (ArithmeticException e) {

            System.out.println(
                "Overflow rejected: " + e.getMessage()
            );
        }
    }
}
