class ParkingSpot {

    private int spotId;
    private String vehicleNumber;
    private boolean occupied;

    public ParkingSpot(int spotId) {
        if (spotId <= 0) {
            throw new IllegalArgumentException("Invalid Parking Spot ID");
        }

        this.spotId = spotId;
        this.occupied = false;
    }

    public void parkVehicle(String vehicleNumber) {

        if (occupied) {
            throw new IllegalStateException("Parking spot is already occupied");
        }

        if (vehicleNumber == null || vehicleNumber.isBlank()) {
            throw new IllegalArgumentException("Vehicle number is required");
        }

        this.vehicleNumber = vehicleNumber;
        occupied = true;
    }

    public void display() {
        System.out.println("Spot ID: " + spotId);
        System.out.println("Vehicle: " + vehicleNumber);
        System.out.println("Occupied: " + occupied);
    }
}