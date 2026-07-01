public class SmartHomeDevicesDemo {
    public static void main(String[] args) {
        Device device = new Device("D100", "ON");
        Thermostat thermostat = new Thermostat("D200", "ON", 24.5);

        device.displayStatus();
        thermostat.displayStatus();
    }

    static class Device {
        String deviceId;
        String status;

        Device(String deviceId, String status) {
            this.deviceId = deviceId;
            this.status = status;
        }

        void displayStatus() {
            System.out.println("Device ID: " + deviceId + " | Status: " + status);
        }
    }

    static class Thermostat extends Device {
        double temperatureSetting;

        Thermostat(String deviceId, String status, double temperatureSetting) {
            super(deviceId, status);
            this.temperatureSetting = temperatureSetting;
        }

        @Override
        void displayStatus() {
            System.out.println("Device ID: " + deviceId + " | Status: " + status + " | Temperature: " + temperatureSetting + "C");
        }
    }
}
