package Student;
public class Student {
    String name;
    int rollNo;
    String department;
    public Student(String name, int rollNo, String department) {
        this.name = name;
        this.rollNo = rollNo;
        this.department = department;
    }
    public void display() {
        System.out.println("Student Name: " + name);
        System.out.println("Roll Number: " + rollNo);
        System.out.println("Department: " + department);
    }
}
