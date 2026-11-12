public class Main {

    public static void main(String[] args) {

        ParkingSpot p1 =
            new ParkingSpot(101, "Hyderabad");

        p1.parkVehicle("TS09AB1234");

        p1.displayDetails();
    }
}