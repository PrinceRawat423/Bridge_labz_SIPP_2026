public class SubscriptionAnalyzerDemo {
    public static void main(String[] args) {
        Subscription[] subscriptions = {
            new BasicPlan("Asha", "S101", 500),
            new PremiumPlan("Ravi", "P202", 1200),
            new FamilyPlan("Neha", "F303", 1800)
        };

        System.out.println("Total revenue: " + calculateTotalRevenue(subscriptions));
        System.out.println("Search P202: " + searchById(subscriptions, "P202"));
        System.out.println("Names starting with 'A':");
        displayByPrefix(subscriptions, "A");
        System.out.println("Most expensive subscription: " + findMostExpensive(subscriptions));
    }

    static double calculateTotalRevenue(Subscription[] subscriptions) {
        double total = 0;
        for (Subscription subscription : subscriptions) {
            total += subscription.calculateMonthlyCharge();
        }
        return total;
    }

    static String searchById(Subscription[] subscriptions, String subscriptionId) {
        for (Subscription subscription : subscriptions) {
            if (subscription.subscriptionId.equals(subscriptionId)) {
                return subscription.subscriberName + " pays " + subscription.calculateMonthlyCharge();
            }
        }
        return "Not found";
    }

    static void displayByPrefix(Subscription[] subscriptions, String prefix) {
        for (Subscription subscription : subscriptions) {
            if (subscription.subscriberName.startsWith(prefix)) {
                System.out.println(subscription.subscriberName + " (" + subscription.subscriptionId + ")");
            }
        }
    }

    static String findMostExpensive(Subscription[] subscriptions) {
        Subscription expensive = subscriptions[0];
        for (Subscription subscription : subscriptions) {
            if (subscription.calculateMonthlyCharge() > expensive.calculateMonthlyCharge()) {
                expensive = subscription;
            }
        }
        return expensive.subscriberName + " (" + expensive.subscriptionId + ")";
    }

    static abstract class Subscription {
        String subscriberName;
        String subscriptionId;

        Subscription(String subscriberName, String subscriptionId) {
            this.subscriberName = subscriberName;
            this.subscriptionId = subscriptionId;
        }

        abstract double calculateMonthlyCharge();
    }

    static class BasicPlan extends Subscription {
        double price;

        BasicPlan(String subscriberName, String subscriptionId, double price) {
            super(subscriberName, subscriptionId);
            this.price = price;
        }

        @Override
        double calculateMonthlyCharge() {
            return price;
        }
    }

    static class PremiumPlan extends Subscription {
        double price;

        PremiumPlan(String subscriberName, String subscriptionId, double price) {
            super(subscriberName, subscriptionId);
            this.price = price;
        }

        @Override
        double calculateMonthlyCharge() {
            return price + 300;
        }
    }

    static class FamilyPlan extends Subscription {
        double price;

        FamilyPlan(String subscriberName, String subscriptionId, double price) {
            super(subscriberName, subscriptionId);
            this.price = price;
        }

        @Override
        double calculateMonthlyCharge() {
            return price + 500;
        }
    }
}
