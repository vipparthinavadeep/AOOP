public class Program1Demo {

    public static void main(String[] args) {

        double x = 0.1 + 0.2;

        System.out.println(x);
        System.out.println(x == 0.3);

        double total = 0;

        for (int i = 0; i < 10; i++) {
            total += 0.10;
        }

        System.out.println(total);

        long paise = 0;

        for (int i = 0; i < 10; i++) {
            paise += 10;
        }

        System.out.println(paise);
    }
}