import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        // Create Hotel
        Hotel hotel = new Hotel();

        // Create Guest
        Guest guest1 = new Guest("Rahul");

        // Create Room
        Room room1 = new Room(101);

        // Create Stay Period
        StayPeriod stay1 = new StayPeriod(
            LocalDate.of(2026, 12, 10),
            LocalDate.of(2026, 12, 15)
        );

        // Create Reservation
        Reservation r1 = new Reservation(
            guest1, room1, stay1
        );

        // Make Reservation
        hotel.makeReservation(r1);

        // Confirm Reservation
        r1.confirm(true);

        // Check In
        r1.checkIn();

        // Check Out
        r1.checkOut();

        // Display Reservations
        hotel.displayReservations();
    }
}