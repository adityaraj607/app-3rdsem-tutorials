import java.util.Scanner;
class Employee {
    String name;
    int id;
    double basicSalary;
    Employee(String name, int id, double basicSalary) {
        this.name = name;
        this.id = id;
        this.basicSalary = basicSalary;
    }
    double calculateSalary() {
        return basicSalary;
    }
    void display() {
        System.out.println("Name: " + name);
        System.out.println("Employee ID: " + id);
        System.out.println("Salary: ₹" + calculateSalary());
        System.out.println();
    }
}
class Professor extends Employee {
    Professor(String name, int id, double basicSalary) {
        super(name, id, basicSalary);
    }
    double calculateSalary() {
        return basicSalary + 20000;
    }
}
class LabAssistant extends Employee {
    LabAssistant(String name, int id, double basicSalary) {
        super(name, id, basicSalary);
    }
    double calculateSalary() {
        return basicSalary + 10000;
    }
}
class AdministrativeStaff extends Employee {
    AdministrativeStaff(String name, int id, double basicSalary) {
        super(name, id, basicSalary);
    }
    double calculateSalary() {
        return basicSalary + 5000;
    }
}
public class Q2 {
    public static void main(String[] args) {
        Employee[] employees = new Employee[3];
        employees[0] = new Professor("Arun", 101, 50000);
        employees[1] = new LabAssistant("Priya", 102, 30000);
        employees[2] = new AdministrativeStaff("Ravi", 103, 25000);
        for (int i = 0; i < 3; i++) {
            employees[i].display();
        }
    }
}