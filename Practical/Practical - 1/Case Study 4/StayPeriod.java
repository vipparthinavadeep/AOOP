import java.time.LocalDate;

public class StayPeriod {

    private LocalDate checkIn;
    private LocalDate checkOut;

    // Constructor
    public StayPeriod(LocalDate checkIn, LocalDate checkOut) {

        if (checkIn == null || checkOut == null) {
            throw new IllegalArgumentException("Dates cannot be null");
        }

        if (!checkOut.isAfter(checkIn)) {
            throw new IllegalArgumentException(
                "Check-out must be after check-in"
            );
        }

        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    // Check overlapping dates
    public boolean overlaps(StayPeriod other) {

        return checkIn.isBefore(other.checkOut)
            && other.checkIn.isBefore(checkOut);
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }
}