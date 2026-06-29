public class ShapeHierarchyDemo {
    public static void main(String[] args) {
        Shape[] shapes = {
                new Circle(5),
                new Rectangle(4, 6),
                new Triangle(3, 4, 5)
        };

        System.out.println("Shape Area Report");
        System.out.println("-----------------");
        for (Shape shape : shapes) {
            System.out.printf("%s -> Area: %.2f, Perimeter: %.2f%n",
                    shape.getClass().getSimpleName(),
                    shape.area(),
                    shape.perimeter());
        }
    }
}

abstract class Shape {
    abstract double area();

    abstract double perimeter();
}

class Circle extends Shape {
    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    double area() {
        return Math.PI * radius * radius;
    }

    @Override
    double perimeter() {
        return 2 * Math.PI * radius;
    }
}

class Rectangle extends Shape {
    private double length;
    private double breadth;

    public Rectangle(double length, double breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    @Override
    double area() {
        return length * breadth;
    }

    @Override
    double perimeter() {
        return 2 * (length + breadth);
    }
}

class Triangle extends Shape {
    private double side1;
    private double side2;
    private double side3;

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    @Override
    double area() {
        double semiPerimeter = perimeter() / 2;
        return Math.sqrt(semiPerimeter * (semiPerimeter - side1) * (semiPerimeter - side2) * (semiPerimeter - side3));
    }

    @Override
    double perimeter() {
        return side1 + side2 + side3;
    }
}
