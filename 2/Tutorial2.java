import java.util.Scanner;
class Book{
    int price;
    String title;
    String author;
    public void display(){
        System.out.println("    Book Details   ");
        System.out.println("Title:  "+title);
        System.out.println("Author: "+author);
        System.out.println("Price:  "+price);
    }
}
public class Tutorial2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Book b = new Book();
        System.out.print("Enter Book title: ");
        b.title = sc.nextLine();
        System.out.print("Enter Author name: ");
        b.author = sc.nextLine();
        System.out.print("Enter Price: ");
        b.price = sc.nextInt();
        b.display();
    }
}
