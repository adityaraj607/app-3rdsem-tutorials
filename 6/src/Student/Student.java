package Student;
public class Student{
    public String name;
    public int rollNo;
    public Student(String name,int rollNo){
        this.name=name;
        this.rollNo=rollNo;
    }
    public void display(){
        System.out.println(name+" "+rollNo);
    }
}