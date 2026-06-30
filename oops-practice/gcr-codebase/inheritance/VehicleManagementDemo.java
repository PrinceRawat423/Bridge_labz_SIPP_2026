public class VehicleManagementDemo {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle("Model X", 220);
        ElectricVehicle electricVehicle = new ElectricVehicle("Model S", 250);
        PetrolVehicle petrolVehicle = new PetrolVehicle("Civic", 180);

        System.out.println(vehicle);
        electricVehicle.charge();
        petrolVehicle.refuel();
    }

    interface Refuelable {
        void refuel();
    }

    static class Vehicle {
        String model;
        int maxSpeed;

        Vehicle(String model, int maxSpeed) {
            this.model = model;
            this.maxSpeed = maxSpeed;
        }

        @Override
        public String toString() {
            return "Vehicle{model='" + model + "', maxSpeed=" + maxSpeed + "}";
        }
    }

    static class ElectricVehicle extends Vehicle {
        ElectricVehicle(String model, int maxSpeed) {
            super(model, maxSpeed);
        }

        void charge() {
            System.out.println(model + " is charging.");
        }
    }

    static class PetrolVehicle extends Vehicle implements Refuelable {
        PetrolVehicle(String model, int maxSpeed) {
            super(model, maxSpeed);
        }

        @Override
        public void refuel() {
            System.out.println(model + " is refueled.");
        }
    }
}
