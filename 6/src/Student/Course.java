package Course;
public class Course{
    public String name;
    public String code;
    public Course(String name,String code){
        this.name=name;
        this.code=code;
    }
    public void display(){
        System.out.println(name+" "+code);
    }
}