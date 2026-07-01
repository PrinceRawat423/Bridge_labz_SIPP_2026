public class HealthMonitoringDemo {
    interface HeartRateMonitor {
        void displayHeartRate(String patientId);

        default void displayHealthTips() {
            System.out.println("Tip: stay hydrated and rest well.");
        }
    }

    interface TemperatureMonitor {
        void displayTemperature(String patientId);

        default void displayHealthTips() {
            System.out.println("Tip: monitor body temperature regularly.");
        }
    }

    static class HealthMonitoringSystem implements HeartRateMonitor, TemperatureMonitor {
        private final String[] patientNames;
        private final String[] patientIds;

        HealthMonitoringSystem(String[] patientNames, String[] patientIds) {
            this.patientNames = patientNames;
            this.patientIds = patientIds;
        }

        @Override
        public void displayHeartRate(String patientId) {
            System.out.println("Heart rate for " + patientId + ": 78 bpm");
        }

        @Override
        public void displayTemperature(String patientId) {
            System.out.println("Temperature for " + patientId + ": 98.6 F");
        }

        @Override
        public void displayHealthTips() {
            HeartRateMonitor.super.displayHealthTips();
            TemperatureMonitor.super.displayHealthTips();
        }

        static boolean isPatientIdValid(String patientId) {
            return patientId != null && patientId.matches("P\\d{3}");
        }

        void generateHealthReport() {
            displayHealthTips();
            for (int i = 0; i < patientNames.length; i++) {
                String id = patientIds[i];
                System.out.println("Patient: " + patientNames[i] + " | ID: " + id + " | Valid: " + isPatientIdValid(id));
                displayHeartRate(id);
                displayTemperature(id);
            }
        }
    }

    public static void main(String[] args) {
        String[] names = {"Asha", "Mohan", "Neha"};
        String[] ids = {"P101", "P202", "ABC"};

        HealthMonitoringSystem system = new HealthMonitoringSystem(names, ids);
        system.generateHealthReport();
    }
}
