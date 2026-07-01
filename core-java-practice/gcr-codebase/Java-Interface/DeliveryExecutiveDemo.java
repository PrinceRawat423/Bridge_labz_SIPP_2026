public class DeliveryExecutiveDemo {
    interface FoodDelivery {
        void deliverFood(String customerName);

        default void trackOrder() {
            System.out.println("Tracking food order...");
        }
    }

    interface GroceryDelivery {
        void deliverGroceries(String customerName);

        default void trackOrder() {
            System.out.println("Tracking grocery order...");
        }
    }

    static class DeliveryExecutive implements FoodDelivery, GroceryDelivery {
        private final String[] customers;

        DeliveryExecutive(String[] customers) {
            this.customers = customers;
        }

        @Override
        public void deliverFood(String customerName) {
            System.out.println("Food delivered to " + customerName);
        }

        @Override
        public void deliverGroceries(String customerName) {
            System.out.println("Groceries delivered to " + customerName);
        }

        @Override
        public void trackOrder() {
            FoodDelivery.super.trackOrder();
            GroceryDelivery.super.trackOrder();
        }

        void processDeliveries() {
            for (String customer : customers) {
                deliverFood(customer);
                deliverGroceries(customer);
                trackOrder();
            }
        }
    }

    public static void main(String[] args) {
        String[] customers = {"Riya", "Karan", "Meera"};
        DeliveryExecutive executive = new DeliveryExecutive(customers);
        executive.processDeliveries();
    }
}
