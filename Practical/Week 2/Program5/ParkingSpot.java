class Booking {

    private int bookingId;
    private String status;
    private int startTime;
    private int endTime;

    // Constructor
    Booking(int bookingId, int startTime, int endTime) {

        if (bookingId <= 0) {
            throw new IllegalArgumentException(
                "Invalid booking ID"
            );
        }

        if (endTime <= startTime) {
            throw new IllegalArgumentException(
                "End time must be after start time"
            );
        }

        this.bookingId = bookingId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = "CREATED";
    }

    // Confirm booking
    void confirmBooking() {

        if (!status.equals("CREATED")) {
            throw new IllegalStateException(
                "Only created bookings can be confirmed"
            );
        }

        status = "CONFIRMED";
    }

    // Activate booking
    void activateBooking() {

        if (!status.equals("CONFIRMED")) {
            throw new IllegalStateException(
                "Only confirmed bookings can be activated"
            );
        }

        status = "ACTIVE";
    }

    // Complete booking
    void completeBooking() {

        if (!status.equals("ACTIVE")) {
            throw new IllegalStateException(
                "Only active bookings can be completed"
            );
        }

        status = "COMPLETED";
    }

    // Display status
    void displayStatus() {

        System.out.println("Booking ID: " + bookingId);
        System.out.println("Status: " + status);
    }
}