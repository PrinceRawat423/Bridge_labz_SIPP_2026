public class OnlineFoodDeliverySystem {
    public static void main(String[] args) {
        VegItem vegItem = new VegItem();
        vegItem.setItemName("Veg Burger");
        vegItem.setPrice(120);
        vegItem.setQuantity(2);
        vegItem.displayItemDetails();
        System.out.println("Total Price: " + vegItem.calculateTotalPrice());

        System.out.println();

        NonVegItem nonVegItem = new NonVegItem();
        nonVegItem.setItemName("Chicken Burger");
        nonVegItem.setPrice(180);
        nonVegItem.setQuantity(2);
        nonVegItem.setServiceCharge(20);
        nonVegItem.displayItemDetails();
        System.out.println("Total Price: " + nonVegItem.calculateTotalPrice());
    }
}

abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void displayItemDetails() {
        System.out.println("Item Name: " + itemName);
        System.out.println("Price: " + price);
        System.out.println("Quantity: " + quantity);
    }

    public abstract double calculateTotalPrice();
}

class VegItem extends FoodItem {
    @Override
    public double calculateTotalPrice() {
        return getPrice() * getQuantity();
    }
}

class NonVegItem extends FoodItem {
    private double serviceCharge;

    public double getServiceCharge() {
        return serviceCharge;
    }

    public void setServiceCharge(double serviceCharge) {
        this.serviceCharge = serviceCharge;
    }

    @Override
    public double calculateTotalPrice() {
        return (getPrice() * getQuantity()) + serviceCharge;
    }
}
