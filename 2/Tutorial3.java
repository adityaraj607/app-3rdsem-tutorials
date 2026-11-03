import java.util.Scanner;
class Stu{
    String name;
    int rollno;
    public void display(){
        System.out.println("    Student Details   ");
        System.out.println("Name:       "+name);
        System.out.println("Roll no:    "+rollno);
    }
}
public class Tutorial3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stu s = new Stu();
        System.out.print("Enter Name: ");
        s.name = sc.nextLine();
        System.out.print("Enter Roll No: ");
        s.rollno = sc.nextInt();
        s.display();
    }
}
