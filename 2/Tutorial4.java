import java.util.Scanner;
class Rectangle{
    double length, breadth;
    public double calcArea(){
        return length*breadth;
    }
}
public class Tutorial4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Rectangle r1 = new Rectangle();
        System.out.print("Enter the length: ");
        r1.length = sc.nextDouble();
        System.out.print("Enter the breadth: ");
        r1.breadth = sc.nextDouble();
        System.out.print("The Area is: " + r1.calcArea());
    }
}

