public class InheritanceFundamentalDemo {
    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.makeSound();

        Dog dog = new Dog();
        dog.makeSound();
        dog.showBreed();

        Cat cat = new Cat();
        cat.makeSound();
        cat.showColor();
    }
}

class Animal {
    String type = "Animal";

    void makeSound() {
        System.out.println("Animal makes a sound.");
    }
}

class Dog extends Animal {
    String breed = "Labrador";

    @Override
    void makeSound() {
        System.out.println("Dog barks.");
    }

    void showBreed() {
        System.out.println("Breed: " + breed);
    }
}

class Cat extends Animal {
    String color = "Black";

    @Override
    void makeSound() {
        System.out.println("Cat meows.");
    }

    void showColor() {
        System.out.println("Color: " + color);
    }
}
