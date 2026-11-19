import java.util.Currency;

public class Program3Demo {

    public static void main(String[] args) {

        // INR Currency
        Currency c1 = Currency.getInstance("INR");

        System.out.println("Currency 1: " +
                c1.getCurrencyCode());

        System.out.println("Currency Name: " +
                c1.getDisplayName());

        System.out.println("Decimal Digits: " +
                c1.getDefaultFractionDigits());


        // USD Currency
        Currency c2 = Currency.getInstance("USD");

        System.out.println("\nCurrency 2: " +
                c2.getCurrencyCode());

        System.out.println("Decimal Digits: " +
                c2.getDefaultFractionDigits());


        // JPY Currency
        Currency c3 = Currency.getInstance("JPY");

        System.out.println("\nCurrency 3: " +
                c3.getCurrencyCode());

        System.out.println("Decimal Digits: " +
                c3.getDefaultFractionDigits());


        // Invalid Currency
        try {

            Currency c4 = Currency.getInstance("ABC");

            System.out.println(c4);

        } catch (IllegalArgumentException e) {

            System.out.println("\nInvalid Currency Code!");
        }
    }
}