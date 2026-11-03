import java.util.Scanner;
class Product {
    int id;
    String name;
    int price;
    int quantity;

    void display() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Price: " + price);
        System.out.println("Quantity: " + quantity);
    }
}
public class Q1 {
    public static void main(String[] args){
        Product[] products=new Product[5];
        for (int i=0;i<5;i++){
            Scanner sc=new Scanner(System.in);
            products[i]=new Product();

            System.out.print("Enter Name: ");
            products[i].name=sc.nextLine();
            System.out.print("Enter ID: ");
            products[i].id=sc.nextInt();
            System.out.print("Enter Price: ");
            products[i].price=sc.nextInt();
            System.out.print("Enter Quantity: ");
            products[i].quantity=sc.nextInt();
        }
        int i=1;
        for(Product p:products){
            System.out.println("Product"+(i++)+":");
            System.out.println("Name: "+p.name);
            System.out.println("ID: "+p.id);
            System.out.println("Price: "+p.price);
            System.out.println("Quantity: "+p.quantity);
            System.out.println("Total Price: "+p.price*p.quantity);
            System.out.println("Discount: "+p.price*p.quantity*0.5);
            System.out.println("Final Price: "+p.price*p.quantity*0.95);
        }
    }
}
