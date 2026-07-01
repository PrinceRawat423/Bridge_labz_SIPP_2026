interface FoodDelivery {
    void deliverFood(String customerName);

    default void trackOrder() {
        System.out.println("FoodDelivery: Tracking food order status.");
    }

    static String generateDeliveryCode() {
        return "DEL" + System.currentTimeMillis();
    }
}

interface GroceryDelivery {
    void deliverGrocery(String customerName);

    default void trackOrder() {
        System.out.println("GroceryDelivery: Tracking grocery order status.");
    }
}

class DeliveryExecutive implements FoodDelivery, GroceryDelivery {
    @Override
    public void deliverFood(String customerName) {
        System.out.println("Delivering food to " + customerName + ". Code: " + FoodDelivery.generateDeliveryCode());
    }

    @Override
    public void deliverGrocery(String customerName) {
        System.out.println("Delivering groceries to " + customerName + ". Code: " + FoodDelivery.generateDeliveryCode());
    }

    @Override
    public void trackOrder() {
        FoodDelivery.super.trackOrder();
        GroceryDelivery.super.trackOrder();
    }

    public void processDeliveries(String[] customers) {
        for (String customer : customers) {
            deliverFood(customer);
            deliverGrocery(customer);
        }
    }

    public static void main(String[] args) {
        String[] customers = {"Rohit", "Sara", "Priya"};
        DeliveryExecutive executive = new DeliveryExecutive();
        executive.trackOrder();
        executive.processDeliveries(customers);
    }
}
