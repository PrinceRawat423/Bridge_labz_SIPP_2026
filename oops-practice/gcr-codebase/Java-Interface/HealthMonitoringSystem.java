interface HeartRateMonitor {
    int readHeartRate(String patientId);

    default void displayHealthTips() {
        System.out.println("HeartRateMonitor tips: Stay active and drink water.");
    }

    static boolean isPatientIdValid(String patientId) {
        return patientId != null && patientId.matches("PAT[0-9]{4}");
    }
}

interface TemperatureMonitor {
    double readTemperature(String patientId);

    default void displayHealthTips() {
        System.out.println("TemperatureMonitor tips: Keep a steady room temperature and rest.");
    }
}

class HealthMonitoringSystem implements HeartRateMonitor, TemperatureMonitor {
    @Override
    public int readHeartRate(String patientId) {
        return 70 + Math.abs(patientId.hashCode() % 20);
    }

    @Override
    public double readTemperature(String patientId) {
        return 36.5 + Math.abs(patientId.hashCode() % 10) * 0.1;
    }

    @Override
    public void displayHealthTips() {
        HeartRateMonitor.super.displayHealthTips();
        TemperatureMonitor.super.displayHealthTips();
    }

    public void generateReport(String[] patientNames, String[] patientIds) {
        for (int i = 0; i < patientNames.length; i++) {
            String id = patientIds[i];
            boolean validId = HeartRateMonitor.isPatientIdValid(id);
            System.out.println(patientNames[i] + " (" + id + "):");
            if (!validId) {
                System.out.println("  INVALID PATIENT ID");
                continue;
            }
            System.out.println("  Heart Rate: " + readHeartRate(id));
            System.out.println("  Temperature: " + String.format("%.1f", readTemperature(id)));
        }
    }

    public static void main(String[] args) {
        String[] patientNames = {"Ahmad", "Neha", "Sonal"};
        String[] patientIds = {"PAT0001", "INVALID", "PAT0003"};
        HealthMonitoringSystem system = new HealthMonitoringSystem();
        system.displayHealthTips();
        system.generateReport(patientNames, patientIds);
    }
}
