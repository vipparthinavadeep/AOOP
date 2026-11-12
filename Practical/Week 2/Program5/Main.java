public class Main {

    public static void main(String[] args) {

        Booking b1 = new Booking(501, 10, 12);

        b1.confirmBooking();

        b1.activateBooking();

        b1.completeBooking();

        b1.displayStatus();
    }
}