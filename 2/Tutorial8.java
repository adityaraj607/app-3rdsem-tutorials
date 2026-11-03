import java.util.Scanner;

class Temperature{
    Scanner sc=new Scanner(System.in);
    double temp;
    void getTemp(){
        System.out.print("Enter Temperature to store: ");
        temp=sc.nextDouble();
    }
    double calFahrenheit(){
        return (temp*9/5)+32;
    }
    void display(){
        System.out.println("Temperature in celsius: "+temp);
        System.out.println("Temperature in fahrenheit: "+calFahrenheit());
    }
}
public class Tutorial8 {
    public static void main(String[] args){
        Temperature t=new Temperature();
        t.getTemp();
        t.display();
    }
}
