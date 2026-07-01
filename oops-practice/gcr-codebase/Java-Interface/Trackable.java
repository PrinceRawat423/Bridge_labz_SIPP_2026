public interface Trackable {
    void logActivity(String activity, int durationMinutes);

    default void resetData() {
        System.out.println("Trackable data has been reset.");
    }
}

interface Reportable {
    void generateReport();
}

interface Notifiable {
    void sendAlert(String message);
}

class FitnessDevice implements Trackable, Reportable, Notifiable {
    private StringBuilder activityLog = new StringBuilder();

    @Override
    public void logActivity(String activity, int durationMinutes) {
        activityLog.append(activity).append(" - ").append(durationMinutes).append(" mins\n");
    }

    @Override
    public void generateReport() {
        System.out.println("Fitness Report:");
        System.out.println(activityLog.toString());
    }

    @Override
    public void sendAlert(String message) {
        System.out.println("ALERT: " + message);
    }
}

class FitnessDeviceDemo {
    public static void main(String[] args) {
        FitnessDevice device = new FitnessDevice();
        device.logActivity("Running", 30);
        device.logActivity("Cycling", 45);
        device.generateReport();
        device.sendAlert("Time to hydrate!");
        device.resetData();
    }
}
