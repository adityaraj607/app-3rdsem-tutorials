import java.util.Scanner;
class Employee{
    Scanner sc = new Scanner(System.in);
    int empid;
    String name;
    double salary;
    String dept;
    public void display(){
        System.out.println("\n  Employee details  ");
        System.out.println("Name: "+name);
        System.out.println("ID  : "+empid);
        System.out.println("Department: "+dept);
        System.out.println("Salary: "+salary);
    }
    public void getData(){
        System.out.print("Enter Name: ");
        name=sc.nextLine();
        System.out.print("Enter Department: ");
        dept=sc.nextLine();
        System.out.print("Enter EmpID: ");
        empid=sc.nextInt();
        System.out.print("Enter Salary: ");
        salary=sc.nextDouble();
    }
}
public class Tutorial6 {
    public static void main(String[] args){
        Employee emp1 = new Employee();
        Employee emp2 = new Employee();
        emp1.getData();
        emp2.getData();
        emp1.display();
        emp2.display();
    }
}

