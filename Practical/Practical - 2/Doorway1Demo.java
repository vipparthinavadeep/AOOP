class ParkingSpot {

    private final int spotId;
    private boolean available = true;
    private String vehicleNumber;

    public ParkingSpot(int spotId) {

        if (spotId <= 0) {
            throw new IllegalArgumentException("Invalid ID");
        }

        this.spotId = spotId;
    }

    // Park vehicle
    public void park(String vehicleNumber) {

        if (!available) {
            throw new IllegalStateException("Spot already occupied");
        }

        if (vehicleNumber == null || vehicleNumber.isBlank()) {
            throw new IllegalArgumentException("Vehicle number required");
        }

        this.vehicleNumber = vehicleNumber;
        available = false;
    }

    // Release parking spot
    public void release() {

        if (available) {
            throw new IllegalStateException("Spot already free");
        }

        vehicleNumber = null;
        available = true;
    }

    public void display() {

        System.out.println("Spot ID: " + spotId);
        System.out.println("Available: " + available);
        System.out.println("Vehicle: " + vehicleNumber);
    }
}

public class Doorway1Demo {

    public static void main(String[] args) {

        ParkingSpot p = new ParkingSpot(101);

        System.out.println("Initial Status");
        p.display();

        System.out.println("\nParking Vehicle");
        p.park("TS09AB1234");
        p.display();

        System.out.println("\nReleasing Vehicle");
        p.release();
        p.display();
    }
}
