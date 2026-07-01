public class VehicleRentalSystem {
    public static void main(String[] args) {
        Car car = new Car();
        car.setVehicleNumber("CAR-101");
        car.setVehicleType("Car");
        car.setDailyRate(1500);

        Bike bike = new Bike();
        bike.setVehicleNumber("BIKE-202");
        bike.setVehicleType("Bike");
        bike.setDailyRate(500);

        Truck truck = new Truck();
        truck.setVehicleNumber("TRUCK-303");
        truck.setVehicleType("Truck");
        truck.setDailyRate(2500);
        truck.setLoadingCharge(1000);

        int days = 3;

        displayVehicle(car, days);
        displayVehicle(bike, days);
        displayVehicle(truck, days);
    }

    private static void displayVehicle(Vehicle vehicle, int days) {
        System.out.println("Vehicle Number: " + vehicle.getVehicleNumber());
        System.out.println("Vehicle Type: " + vehicle.getVehicleType());
        System.out.println("Rental Cost for " + days + " days: " + vehicle.calculateRentalCost(days));
        System.out.println();
    }
}

abstract class Vehicle {
    private String vehicleNumber;
    private String vehicleType;

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public abstract double calculateRentalCost(int days);
}

class Car extends Vehicle {
    private double dailyRate;

    public double getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(double dailyRate) {
        this.dailyRate = dailyRate;
    }

    @Override
    public double calculateRentalCost(int days) {
        return days * dailyRate;
    }
}

class Bike extends Vehicle {
    private double dailyRate;

    public double getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(double dailyRate) {
        this.dailyRate = dailyRate;
    }

    @Override
    public double calculateRentalCost(int days) {
        return days * dailyRate;
    }
}

class Truck extends Vehicle {
    private double dailyRate;
    private double loadingCharge;

    public double getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(double dailyRate) {
        this.dailyRate = dailyRate;
    }

    public double getLoadingCharge() {
        return loadingCharge;
    }

    public void setLoadingCharge(double loadingCharge) {
        this.loadingCharge = loadingCharge;
    }

    @Override
    public double calculateRentalCost(int days) {
        return (days * dailyRate) + loadingCharge;
    }
}
