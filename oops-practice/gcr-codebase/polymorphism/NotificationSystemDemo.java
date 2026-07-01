public class NotificationSystemDemo {
    public static void main(String[] args) {
        Notification[] notifications = {
            new EmailNotification("Asha", "Welcome to our service."),
            new SMSNotification("Ravi", "Your OTP is 123456."),
            new PushNotification("Neha", "You have a new badge.")
        };

        for (Notification notification : notifications) {
            notification.sendNotification();
        }
    }

    static class Notification {
        String recipientName;
        String message;

        Notification(String recipientName, String message) {
            this.recipientName = recipientName;
            this.message = message;
        }

        void sendNotification() {
            System.out.println("Sending notification to " + recipientName + ": " + message);
        }
    }

    static class EmailNotification extends Notification {
        EmailNotification(String recipientName, String message) {
            super(recipientName, message);
        }

        @Override
        void sendNotification() {
            System.out.println("Email to " + recipientName + ": " + message);
        }
    }

    static class SMSNotification extends Notification {
        SMSNotification(String recipientName, String message) {
            super(recipientName, message);
        }

        @Override
        void sendNotification() {
            System.out.println("SMS to " + recipientName + ": " + message);
        }
    }

    static class PushNotification extends Notification {
        PushNotification(String recipientName, String message) {
            super(recipientName, message);
        }

        @Override
        void sendNotification() {
            System.out.println("Push to " + recipientName + ": " + message);
        }
    }
}
