public class Program2Demo {

    public static void main(String[] args) {

        long big = Long.MAX_VALUE;

        System.out.println(big + 1);

        try {

            Math.addExact(big, 1);

        } catch (ArithmeticException e) {

            System.out.println(
                "Overflow detected: " + e.getMessage()
            );
        }
    }
}