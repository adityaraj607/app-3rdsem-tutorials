import java.util.Scanner;
abstract class Shape {
    abstract double calculateArea();
}
class Circle extends Shape {
    double radius;

    Circle(double radius) {
        this.radius = radius;
    }
    double calculateArea() {
        return Math.PI * radius * radius;
    }
}
class Rectangle extends Shape {
    double length;
    double breadth;
    Rectangle(double length, double breadth) {
        this.length = length;
        this.breadth = breadth;
    }
    double calculateArea() {
        return length * breadth;
    }
}
class Triangle extends Shape {
    double base;
    double height;
    Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }
    double calculateArea() {
        return 0.5 * base * height;
    }
}
public class Q5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Circle");
        System.out.println("2. Rectangle");
        System.out.println("3. Triangle");
        System.out.print("Select shape: ");
        int choice = sc.nextInt();
        Shape shape;
        if (choice == 1) {
            System.out.print("Enter radius: ");
            double radius = sc.nextDouble();
            shape = new Circle(radius);
        } else if (choice == 2) {
            System.out.print("Enter length: ");
            double length = sc.nextDouble();
            System.out.print("Enter breadth: ");
            double breadth = sc.nextDouble();
            shape = new Rectangle(length, breadth);
        } else {
            System.out.print("Enter base: ");
            double base = sc.nextDouble();
            System.out.print("Enter height: ");
            double height = sc.nextDouble();
            shape = new Triangle(base, height);
        }
        System.out.println("Area: " + shape.calculateArea());
    }
}