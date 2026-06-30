public class ProductInventoryDemo {
    public static void main(String[] args) {
        Product product1 = new Product("Laptop", 45000);
        Product product2 = new Product("Phone", 18000);

        product1.displayProductDetails();
        product2.displayProductDetails();
        Product.displayTotalProducts();
    }

    static class Product {
        String productName;
        double price;
        static int totalProducts;

        Product(String productName, double price) {
            this.productName = productName;
            this.price = price;
            totalProducts++;
        }

        void displayProductDetails() {
            System.out.println(productName + " costs " + price);
        }

        static void displayTotalProducts() {
            System.out.println("Total products: " + totalProducts);
        }
    }
}
