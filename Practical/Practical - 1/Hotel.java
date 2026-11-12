import java.util.ArrayList;

public class Hotel {

    private ArrayList<Reservation> reservations =
        new ArrayList<>();

    // Make reservation
    public synchronized void makeReservation(
        Reservation newReservation
    ) {

        for (Reservation r : reservations) {

            if (r.getRoomNumber() ==
                newReservation.getRoomNumber()) {

                if (r.getStatus() != ReservationStatus.CANCELLED &&
                    r.getStatus() != ReservationStatus.COMPLETED) {

                    if (r.getStay().overlaps(
                        newReservation.getStay())) {

                        System.out.println(
                            "Room already booked!"
                        );

                        return;
                    }
                }
            }
        }

        reservations.add(newReservation);

        System.out.println(
            "Room Reserved Successfully"
        );
    }

    // Display reservations
    public void displayReservations() {

        for (Reservation r : reservations) {

            System.out.println("Guest: " + r.getGuestName());

            System.out.println(
                "Room: " + r.getRoomNumber()
            );

            System.out.println(
                "Status: " + r.getStatus()
            );

            System.out.println("--------------------");
        }
    }
}