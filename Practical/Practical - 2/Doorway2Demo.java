import java.time.LocalDateTime;

class Booking {

    private final int bookingId;
    private final LocalDateTime startTime;
    private final LocalDateTime endTime;

    public Booking(int id, LocalDateTime start,
                   LocalDateTime end) {

        if (start == null || end == null ||
            !end.isAfter(start)) {

            throw new IllegalArgumentException("Invalid dates");
        }

        bookingId = id;
        startTime = start;
        endTime = end;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void display() {

        System.out.println("Booking ID: " + bookingId);
        System.out.println("Start: " + startTime);
        System.out.println("End: " + endTime);
    }
}

public class Doorway2Demo {

    public static void main(String[] args) {

        LocalDateTime start =
            LocalDateTime.of(2026, 11, 13, 10, 0);

        LocalDateTime end =
            LocalDateTime.of(2026, 11, 13, 12, 0);

        Booking b = new Booking(501, start, end);

        System.out.println("Booking Details");
        b.display();

        System.out.println("\nChecking End Time");
        System.out.println(b.getEndTime());

        System.out.println("\nBooking created successfully");
    }
}
