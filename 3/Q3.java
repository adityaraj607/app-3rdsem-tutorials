import java.util.Scanner;
class Employee{
    int id;
    String name;
    int salary;
    Employee(int id, String name, int salary){
        this.id=id;
        this.name=name;
        this.salary=salary;
    }
    void display(){
        System.out.println("ID: "+id);
        System.out.println("Name: "+name);
        System.out.println("Salary: "+salary);
    }
}
public class Q3 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter Name: ");
        String name=sc.nextLine();
        System.out.print("Enter Employee ID: ");
        int id=sc.nextInt();
        System.out.print("Enter Salary: ");
        int salary=sc.nextInt();

        Employee e1 = new Employee(id,name,salary);
        e1.display();
    }
}
