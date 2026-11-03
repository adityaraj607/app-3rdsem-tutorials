import java.util.Scanner;
class Stud{
    int age;
    String name;
    public void display(){
        System.out.println("\n    Student Details   ");
        System.out.println("Name: "+name);
        System.out.println("Age : "+age);
    }
}
public class Tutorial5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stud s1 = new Stud();
        Stud s2 = new Stud();
        System.out.print("Enter the name of Student 1: ");
        s1.name = sc.nextLine();
        System.out.print("Enter the age of Student 1: ");;
        s1.age=sc.nextInt();
        sc.nextLine();
        System.out.print("Enter the name of Student 2: ");
        s2.name = sc.nextLine();
        System.out.print("Enter the age of Student 2: ");
        s2.age=sc.nextInt();

        s1.display();
        s2.display();
    }
}
