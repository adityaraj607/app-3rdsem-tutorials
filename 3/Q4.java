class Car{
    String model="NA";
    int price=0;
    Car(){}
    Car(String model){
        this.model=model;
    }
    Car(String model, int price){
        this.model=model;
        this.price=price;
    }
    void display(){
        System.out.println("Model: "+model);
        System.out.println("Price: "+price);
    }
}
public class Q4 {
    public static void main(String[] args){
        Car c1 = new Car();
        Car c2 = new Car("Scorpio");
        Car c3 = new Car("XUV",2100000);
        c1.display();
        c2.display();
        c3.display();
    }
}
