import java.util.Scanner;
class Student{
    int rollno;
    String name;
    String dept;
    public void display(){
        System.out.println("    Student Details   ");
        System.out.println("Name:       "+name);
        System.out.println("Roll no:    "+rollno);
        System.out.println("Department: "+dept);
    }
}
public class Tutorial1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student s = new Student();
        System.out.print("Enter Name: ");
        s.name = sc.nextLine();
        System.out.print("Enter Roll No: ");
        s.rollno = sc.nextInt();
        s.dept = sc.nextLine();
        System.out.print("Enter Department: ");
        s.dept = sc.nextLine();
        s.display();
    }
}
