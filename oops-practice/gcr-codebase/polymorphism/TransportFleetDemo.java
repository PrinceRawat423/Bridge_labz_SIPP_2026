public class TransportFleetDemo {
    public static void main(String[] args) {
        Vehicle[] fleet = {
            new Car("KA-01-1234", 12),
            new Bus("KA-02-5678", 5),
            new Bike("KA-03-9012", 35),
            new ElectricCar("KA-04-3456", 8)
        };

        for (Vehicle vehicle : fleet) {
            if (vehicle instanceof Car) {
                System.out.println(vehicle.getVehicleNumber() + " cost: " + vehicle.fuelCost(100));
            } else if (vehicle instanceof Bus) {
                System.out.println(vehicle.getVehicleNumber() + " cost: " + vehicle.fuelCost(100));
            } else if (vehicle instanceof Bike) {
                System.out.println(vehicle.getVehicleNumber() + " cost: " + vehicle.fuelCost(100));
            }
        }
    }

    static class Vehicle {
        private final String vehicleNumber;
        private final int mileage;

        public Vehicle(String vehicleNumber, int mileage) {
            this.vehicleNumber = vehicleNumber;
            this.mileage = mileage;
        }

        public String getVehicleNumber() {
            return vehicleNumber;
        }

        public int getMileage() {
            return mileage;
        }

        public double fuelCost(int km) {
            return km / (double) mileage * 10;
        }
    }

    static class Car extends Vehicle {
        public Car(String vehicleNumber, int mileage) {
            super(vehicleNumber, mileage);
        }

        @Override
        public double fuelCost(int km) {
            return km / (double) getMileage() * 9.5;
        }
    }

    static class Bus extends Vehicle {
        public Bus(String vehicleNumber, int mileage) {
            super(vehicleNumber, mileage);
        }

        @Override
        public double fuelCost(int km) {
            return km / (double) getMileage() * 12;
        }
    }

    static class Bike extends Vehicle {
        public Bike(String vehicleNumber, int mileage) {
            super(vehicleNumber, mileage);
        }

        @Override
        public double fuelCost(int km) {
            return km / (double) getMileage() * 4;
        }
    }

    static class ElectricCar extends Car {
        public ElectricCar(String vehicleNumber, int mileage) {
            super(vehicleNumber, mileage);
        }

        @Override
        public double fuelCost(int km) {
            return 0; // electric car costs zero fuel per km in this simplified model
        }
    }
}
