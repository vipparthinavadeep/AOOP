enum ReservationStatus {
    REQUESTED,
    CONFIRMED,
    CHECKED_IN,
    COMPLETED,
    CANCELLED
}

class Guest {

    String name;

    Guest(String name) {
        this.name = name;
    }
}

class Room {

    int roomNumber;

    Room(int roomNumber) {
        this.roomNumber = roomNumber;
    }
}

public class Reservation {

    private Guest guest;
    private Room room;
    private StayPeriod stay;

    private ReservationStatus status;
    private boolean paymentGuarantee;

    // Constructor
    public Reservation(
        Guest guest,
        Room room,
        StayPeriod stay
    ) {

        this.guest = guest;
        this.room = room;
        this.stay = stay;

        status = ReservationStatus.REQUESTED;
        paymentGuarantee = false;
    }

    // Confirm reservation
    public void confirm(boolean payment) {

        if (status != ReservationStatus.REQUESTED) {
            throw new IllegalStateException("Invalid reservation");
        }

        if (!payment) {
            throw new IllegalStateException(
                "Payment guarantee required"
            );
        }

        paymentGuarantee = true;
        status = ReservationStatus.CONFIRMED;

        System.out.println("Reservation Confirmed");
    }

    // Check-in
    public void checkIn() {

        if (status != ReservationStatus.CONFIRMED) {
            throw new IllegalStateException(
                "Reservation must be confirmed first"
            );
        }

        status = ReservationStatus.CHECKED_IN;

        System.out.println("Guest Checked In");
    }

    // Check-out
    public void checkOut() {

        if (status != ReservationStatus.CHECKED_IN) {
            throw new IllegalStateException(
                "Guest must check in first"
            );
        }

        status = ReservationStatus.COMPLETED;

        System.out.println("Guest Checked Out");
    }

    // Cancel reservation
    public void cancel() {

        if (status != ReservationStatus.REQUESTED &&
            status != ReservationStatus.CONFIRMED) {

            throw new IllegalStateException(
                "Cancellation not allowed"
            );
        }

        status = ReservationStatus.CANCELLED;

        System.out.println("Reservation Cancelled");
    }

    public int getRoomNumber() {
        return room.roomNumber;
    }

    public StayPeriod getStay() {
        return stay;
    }

    public ReservationStatus getStatus() {
        return status;
    }

    public String getGuestName() {
        return guest.name;
    }
}