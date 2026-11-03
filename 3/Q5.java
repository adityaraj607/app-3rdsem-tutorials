class shapes{
    double area(double side) {
        return side * side;
    }
    double area(double length, double breadth) {
        return length * breadth;
    }
    double area(float radius) {
        return Math.PI * radius * radius;
    }
}
public class Q5 {
    public static void main(String[] args){
        shapes s=new shapes();
        System.out.println("Area of Square: "+s.area(5.0));
        System.out.println("Area of Rectangle: "+s.area(10.0, 5.0));
        System.out.println("Area of Circle: "+s.area(7.0f));
    }
}
