public class Level1PracticeDemo {
    public static void main(String[] args) {
        Book book1 = new Book();
        Book book2 = new Book("Java Basics", "Prince", 299.99);

        Circle circle1 = new Circle();
        Circle circle2 = new Circle(7);

        Person person1 = new Person("Rahul", 25);
        Person person2 = new Person(person1);

        HotelBooking booking1 = new HotelBooking();
        HotelBooking booking2 = new HotelBooking("Asha", "Deluxe", 3);
        HotelBooking booking3 = new HotelBooking(booking2);

        Book libraryBook = new Book("Clean Code", "Robert", 499.99, true);
        libraryBook.borrowBook();

        CarRental rental = new CarRental("Neha", "Swift", 5);
        System.out.println("Total car rental cost: " + rental.calculateTotalCost());
    }

    static class Book {
        String title;
        String author;
        double price;
        boolean availability;

        Book() {
            this("Unknown", "Unknown", 0.0, true);
        }

        Book(String title, String author, double price) {
            this(title, author, price, true);
        }

        Book(String title, String author, double price, boolean availability) {
            this.title = title;
            this.author = author;
            this.price = price;
            this.availability = availability;
        }

        void borrowBook() {
            if (availability) {
                System.out.println(title + " borrowed successfully.");
                availability = false;
            } else {
                System.out.println(title + " is not available.");
            }
        }
    }

    static class Circle {
        int radius;

        Circle() {
            this(5);
        }

        Circle(int radius) {
            this.radius = radius;
        }
    }

    static class Person {
        String name;
        int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        Person(Person other) {
            this.name = other.name;
            this.age = other.age;
        }
    }

    static class HotelBooking {
        String guestName;
        String roomType;
        int nights;

        HotelBooking() {
            this("Guest", "Standard", 1);
        }

        HotelBooking(String guestName, String roomType, int nights) {
            this.guestName = guestName;
            this.roomType = roomType;
            this.nights = nights;
        }

        HotelBooking(HotelBooking other) {
            this(other.guestName, other.roomType, other.nights);
        }
    }

    static class CarRental {
        String customerName;
        String carModel;
        int rentalDays;
        double dailyRate = 1200;

        CarRental(String customerName, String carModel, int rentalDays) {
            this.customerName = customerName;
            this.carModel = carModel;
            this.rentalDays = rentalDays;
        }

        double calculateTotalCost() {
            return dailyRate * rentalDays;
        }
    }
}
