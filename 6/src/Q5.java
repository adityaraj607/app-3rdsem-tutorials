import Student.Student;
import Course.Course;
public class Q5{
    public static void main(String[]args){
        Student s=new Student("Aditya",101);
        Course c=new Course("Java","CSE101");
        s.display();
        c.display();
    }
}