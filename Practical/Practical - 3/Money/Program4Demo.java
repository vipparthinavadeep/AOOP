import java.util.Currency;

final class Money {

    private final long amount;
    private final Currency currency;

    // Constructor
    public Money(long amount, String currencyCode) {

        this.amount = amount;
        this.currency = Currency.getInstance(currencyCode);
    }

    // Add money
    public Money add(Money other) {

        if (!currency.equals(other.currency)) {
            throw new IllegalArgumentException(
                "Currency mismatch"
            );
        }

        return new Money(
            Math.addExact(amount, other.amount),
            currency.getCurrencyCode()
        );
    }

    // Display money
    public void display() {

        System.out.println(
            currency.getCurrencyCode() + " " + amount
        );
    }
}

public class Program4Demo {

    public static void main(String[] args) {

        // Create Money objects
        Money m1 = new Money(100, "INR");

        Money m2 = new Money(50, "INR");

        System.out.println("Original Money:");
        m1.display();

        // Add money
        Money m3 = m1.add(m2);

        System.out.println("\nAfter Addition:");
        m3.display();

        System.out.println("\nOriginal Money Remains:");
        m1.display();
    }
}