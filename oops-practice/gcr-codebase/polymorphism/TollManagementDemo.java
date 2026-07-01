public class TollManagementDemo {
    public static void main(String[] args) {
        Vehicle[] vehicles = {
            new Car("KA-01-1111", "Aman", 50),
            new Bus("KA-01-2222", "Deepa", 100),
            new Truck("KA-01-3333", "Rohit", 200)
        };

        System.out.println("Total revenue: " + calculateTotalRevenue(vehicles));
        System.out.println("Highest toll payer: " + searchVehicle(vehicles, "KA-01-2222"));
        displayCountByType(vehicles);
    }

    static double calculateTotalRevenue(Vehicle[] vehicles) {
        double total = 0;
        for (Vehicle vehicle : vehicles) {
            total += vehicle.calculateToll();
        }
        return total;
    }

    static String searchVehicle(Vehicle[] vehicles, String vehicleNumber) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.vehicleNumber.equals(vehicleNumber)) {
                return vehicle.ownerName + " paid " + vehicle.calculateToll();
            }
        }
        return "Not found";
    }

    static void displayCountByType(Vehicle[] vehicles) {
        int cars = 0, buses = 0, trucks = 0;
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Car) cars++;
            else if (vehicle instanceof Bus) buses++;
            else if (vehicle instanceof Truck) trucks++;
        }
        System.out.println("Cars: " + cars + ", Buses: " + buses + ", Trucks: " + trucks);
    }

    static abstract class Vehicle {
        String vehicleNumber;
        String ownerName;

        Vehicle(String vehicleNumber, String ownerName) {
            this.vehicleNumber = vehicleNumber;
            this.ownerName = ownerName;
        }

        abstract double calculateToll();
    }

    static class Car extends Vehicle {
        double tollAmount;

        Car(String vehicleNumber, String ownerName, double tollAmount) {
            super(vehicleNumber, ownerName);
            this.tollAmount = tollAmount;
        }

        @Override
        double calculateToll() {
            return tollAmount;
        }
    }

    static class Bus extends Vehicle {
        double tollAmount;

        Bus(String vehicleNumber, String ownerName, double tollAmount) {
            super(vehicleNumber, ownerName);
            this.tollAmount = tollAmount;
        }

        @Override
        double calculateToll() {
            return tollAmount * 1.2;
        }
    }

    static class Truck extends Vehicle {
        double tollAmount;

        Truck(String vehicleNumber, String ownerName, double tollAmount) {
            super(vehicleNumber, ownerName);
            this.tollAmount = tollAmount;
        }

        @Override
        double calculateToll() {
            return tollAmount * 1.5;
        }
    }
}
