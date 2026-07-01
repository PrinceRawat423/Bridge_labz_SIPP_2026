public class FitnessTrackerDemo {
    interface Trackable {
        void logActivity(String activity);

        default void resetData() {
            System.out.println("Resetting tracker data...");
        }
    }

    interface Reportable {
        void generateReport();
    }

    interface Notifiable {
        void sendAlert(String message);
    }

    static class FitnessDevice implements Trackable, Reportable, Notifiable {
        private final String deviceName;
        private int activityCount;

        FitnessDevice(String deviceName) {
            this.deviceName = deviceName;
        }

        @Override
        public void logActivity(String activity) {
            activityCount++;
            System.out.println(deviceName + " logged: " + activity);
        }

        @Override
        public void generateReport() {
            System.out.println("Report for " + deviceName + ": Total activities = " + activityCount);
        }

        @Override
        public void sendAlert(String message) {
            System.out.println("Alert from " + deviceName + ": " + message);
        }

        @Override
        public void resetData() {
            activityCount = 0;
            System.out.println(deviceName + " data reset.");
        }
    }

    public static void main(String[] args) {
        FitnessDevice device = new FitnessDevice("Band-X");
        device.logActivity("Running");
        device.logActivity("Cycling");
        device.generateReport();
        device.sendAlert("Great progress today!");
        device.resetData();
        device.generateReport();
    }
}
