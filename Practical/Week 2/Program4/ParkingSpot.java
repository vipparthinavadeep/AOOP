class ParkingSpot {

    private int spotId;
    private String location;
    private boolean available;
    private String vehicleNumber;

    // Constructor
    ParkingSpot(int spotId, String location) {

        if (spotId <= 0) {
            throw new IllegalArgumentException(
                "Invalid spot ID"
            );
        }

        this.spotId = spotId;
        this.location = location;
        this.available = true;
        this.vehicleNumber = null;
    }

    // Park vehicle
    void parkVehicle(String vehicleNumber) {

        if (!available) {
            throw new IllegalStateException(
                "Parking spot is already occupied"
            );
        }

        if (vehicleNumber == null ||
            vehicleNumber.isBlank()) {

            throw new IllegalArgumentException(
                "Vehicle number cannot be empty"
            );
        }

        this.vehicleNumber = vehicleNumber;
        this.available = false;
    }

    // Display details
    void displayDetails() {

        System.out.println("Spot ID: " + spotId);
        System.out.println("Location: " + location);
        System.out.println("Available: " + available);
        System.out.println("Vehicle: " + vehicleNumber);
    }
}