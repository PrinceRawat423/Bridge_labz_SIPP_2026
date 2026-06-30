public class OrderManagementDemo {
    public static void main(String[] args) {
        Order order = new Order("ORD1001", "2026-06-30");
        ShippedOrder shippedOrder = new ShippedOrder("ORD1002", "2026-06-30", "TRK12345");
        DeliveredOrder deliveredOrder = new DeliveredOrder("ORD1003", "2026-06-30", "TRK54321", "2026-07-01");

        System.out.println(order.getOrderStatus());
        System.out.println(shippedOrder.getOrderStatus());
        System.out.println(deliveredOrder.getOrderStatus());
    }

    static class Order {
        String orderId;
        String orderDate;

        Order(String orderId, String orderDate) {
            this.orderId = orderId;
            this.orderDate = orderDate;
        }

        String getOrderStatus() {
            return "Order placed";
        }
    }

    static class ShippedOrder extends Order {
        String trackingNumber;

        ShippedOrder(String orderId, String orderDate, String trackingNumber) {
            super(orderId, orderDate);
            this.trackingNumber = trackingNumber;
        }

        @Override
        String getOrderStatus() {
            return "Order shipped with tracking number " + trackingNumber;
        }
    }

    static class DeliveredOrder extends ShippedOrder {
        String deliveryDate;

        DeliveredOrder(String orderId, String orderDate, String trackingNumber, String deliveryDate) {
            super(orderId, orderDate, trackingNumber);
            this.deliveryDate = deliveryDate;
        }

        @Override
        String getOrderStatus() {
            return "Order delivered on " + deliveryDate;
        }
    }
}
