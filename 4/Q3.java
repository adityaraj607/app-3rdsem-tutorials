import java.util.Scanner;
class Employee {
    int id;
    String name;
    double monthlySalary;
    void display() {
        double annualSalary = monthlySalary * 12;
        double bonus = calculateBonus();
        String eligibility = checkEligibility();
        System.out.println("Employee ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Monthly Salary: ₹" + monthlySalary);
        System.out.println("Annual Salary: ₹" + annualSalary);
        System.out.println("Bonus: ₹" + bonus);
        System.out.println("Eligibility: " + eligibility);
        System.out.println();
    }
    double calculateAnnualSalary() {
        return monthlySalary * 12;
    }
    double calculateBonus() {
        return monthlySalary >= 30000 ? calculateAnnualSalary() * 0.10 : 0;
    }
    String checkEligibility() {
        return monthlySalary >= 30000 ? "Eligible" : "Not Eligible";
    }
}
public class Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Employee[] employees = new Employee[5];
        for (int i = 0; i < 5; i++) {
            employees[i] = new Employee();
            System.out.print("Employee ID: ");
            employees[i].id = sc.nextInt();
            sc.nextLine();
            System.out.print("Name: ");
            employees[i].name = sc.nextLine();
            System.out.print("Monthly Salary: ");
            employees[i].monthlySalary = sc.nextDouble();
        }
        for (int i = 0; i < 5; i++) {
            employees[i].display();
        }
    }
}
