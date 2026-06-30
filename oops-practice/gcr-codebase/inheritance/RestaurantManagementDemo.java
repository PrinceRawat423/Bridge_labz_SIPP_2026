public class RestaurantManagementDemo {
    public static void main(String[] args) {
        Person person = new Person("Aman", 101);
        Chef chef = new Chef("Neha", 102, "Italian");
        Waiter waiter = new Waiter("Karan", 103, "Floor 1");

        person.displayInfo();
        chef.displayInfo();
        waiter.displayInfo();
        chef.performDuties();
        waiter.performDuties();
    }

    interface Worker {
        void performDuties();
    }

    static class Person {
        String name;
        int id;

        Person(String name, int id) {
            this.name = name;
            this.id = id;
        }

        void displayInfo() {
            System.out.println("Person: " + name + " (ID: " + id + ")");
        }
    }

    static class Chef extends Person implements Worker {
        String specialty;

        Chef(String name, int id, String specialty) {
            super(name, id);
            this.specialty = specialty;
        }

        @Override
        public void performDuties() {
            System.out.println(name + " is preparing " + specialty + " dishes.");
        }
    }

    static class Waiter extends Person implements Worker {
        String section;

        Waiter(String name, int id, String section) {
            super(name, id);
            this.section = section;
        }

        @Override
        public void performDuties() {
            System.out.println(name + " is serving customers in " + section + ".");
        }
    }
}
