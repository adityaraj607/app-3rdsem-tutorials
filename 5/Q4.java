import java.util.Scanner;
abstract class Product {
    int id;
    String name;
    double price;
    Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
    abstract double calculateDiscount();
    void display() {
        double discount = calculateDiscount();
        double finalPrice = price - discount;
        System.out.println("Product ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Price: ₹" + price);
        System.out.println("Discount: ₹" + discount);
        System.out.println("Final Price: ₹" + finalPrice);
        System.out.println();
    }
}
class Electronics extends Product {
    Electronics(int id, String name, double price) {
        super(id, name, price);
    }
    double calculateDiscount() {
        return price * 0.10;
    }
}
class Clothing extends Product {
    Clothing(int id, String name, double price) {
        super(id, name, price);
    }

    double calculateDiscount() {
        return price * 0.20;
    }
}
class Books extends Product {
    Books(int id, String name, double price) {
        super(id, name, price);
    }
    double calculateDiscount() {
        return price * 0.05;
    }
}
public class Q4 {
    public static void main(String[] args) {
        Product[] products = new Product[3];
        products[0] = new Electronics(101, "Laptop", 50000);
        products[1] = new Clothing(102, "Jacket", 3000);
        products[2] = new Books(103, "Java Book", 1000);
        for (int i = 0; i < 3; i++) {
            products[i].display();
        }
    }
}
