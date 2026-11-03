import Student.Student;
import Course.Course;
public class Main {
    public static void main(String[] args) {
        Student s = new Student("Aditya Raj", 01, "NWC");
        Course c = new Course("Java Programming", "21CSC", 4);
        System.out.println("Student Details");
        s.display();
        System.out.println("\nCourse Details");
        c.display();
    }
}
