import java.util.Scanner;
class Student {
    int roll;
    String name;
    int[] marks = new int[3];
    double attendance;
    void display() {
        int total = 0;
        for (int i = 0; i < 3; i++) {
            total += marks[i];
        }
        double average = total / 3.0;
        String result = (average >= 50) ? "Pass" : "Fail";
        String scholarship = (average >= 75 && attendance >= 80) ? "Eligible" : "Not Eligible";
        String performance = (average >= 85) ? "Excellent" : "Good";
        System.out.println("Roll Number: " + roll);
        System.out.println("Name: " + name);
        System.out.println("Total Marks: " + total);
        System.out.println("Average Marks: " + average);
        System.out.println("Result: " + result);
        System.out.println("Scholarship: " + scholarship);
        System.out.println("Performance: " + performance);
        System.out.println();
    }
    double getAverage() {
        int total = 0;
        for (int i = 0; i < 3; i++) {
            total += marks[i];
        }
        return total / 3.0;
    }
}

public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student[] students = new Student[5];
        for (int i = 0; i < 5; i++) {
            students[i] = new Student();
            System.out.println("Enter details for Student " + (i + 1));
            System.out.print("Roll Number: ");
            students[i].roll = sc.nextInt();
            sc.nextLine();
            System.out.print("Name: ");
            students[i].name = sc.nextLine();
            System.out.println("Enter marks for 3 subjects:");
            for (int j = 0; j < 3; j++) {
                students[i].marks[j] = sc.nextInt();
            }
            System.out.print("Attendance: ");
            students[i].attendance = sc.nextDouble();
            System.out.println();
        }
        for (int i = 0; i < 5; i++) {
            students[i].display();
        }
        Student highest = students[0];
        for (int i = 1; i < 5; i++) {
            if (students[i].getAverage() > highest.getAverage()) {
                highest = students[i];
            }
        }
        System.out.println("Student with Highest Average");
        System.out.println("Roll Number: " + highest.roll);
        System.out.println("Name: " + highest.name);
        System.out.println("Average: " + highest.getAverage());
    }
}