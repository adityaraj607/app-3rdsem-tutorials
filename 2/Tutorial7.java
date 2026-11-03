import java.util.Scanner;
class Marks{
    Scanner sc = new Scanner(System.in);
    int marks1,marks2,marks3;
    void getMarks(){
        System.out.print("Enter Marks for subject1: ");
        marks1=sc.nextInt();
        System.out.print("Enter Marks for subject2: ");
        marks2=sc.nextInt();
        System.out.print("Enter Marks for subject3: ");
        marks3=sc.nextInt();
    }
    int getTotal(){
        return marks1+marks2+marks3;
    }
    int getAvg(){
        return getTotal()/3;
    }
    void display(){
        System.out.println("Total Marks: "+getTotal());
        System.out.println("Average marks: "+getAvg());
    }
}
public class Tutorial7 {
    public static void main(String[] args) {
        Marks stud1 = new Marks();
        stud1.getMarks();
        stud1.display();
    }
}
