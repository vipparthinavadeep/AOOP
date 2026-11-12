class ParkingSpot { 
    int spotId; 
    String location; 
    boolean available; 
    void displayDetails() { 
        System.out.println("Spot ID: " + spotId); 
        System.out.println("Location: " + location); 
        System.out.println("Available: " + available); 
    } 
}