public class Q1{
    static class Vehicle{
        String vehicleNumber,brand;
        int speed;
        Vehicle(String vehicleNumber,String brand,int speed){
            this.vehicleNumber=vehicleNumber;
            this.brand=brand;
            this.speed=speed;
        }
        void displayDetails(){
            System.out.println(vehicleNumber+" "+brand+" "+speed);
        }
    }
    static class Car extends Vehicle{
        int numberOfDoors;
        Car(String vehicleNumber,String brand,int speed,int numberOfDoors){
            super(vehicleNumber,brand,speed);
            this.numberOfDoors=numberOfDoors;
        }
        void displayDetails(){
            System.out.println(vehicleNumber+" "+brand+" "+speed+" "+numberOfDoors);
        }
    }
    static class Bike extends Vehicle{
        boolean hasGear;
        Bike(String vehicleNumber,String brand,int speed,boolean hasGear){
            super(vehicleNumber,brand,speed);
            this.hasGear=hasGear;
        }
        void displayDetails(){
            System.out.println(vehicleNumber+" "+brand+" "+speed+" "+hasGear);
        }
    }
    public static void main(String[]args){
        Vehicle v;
        v=new Car("C101","Toyota",120,4);
        v.displayDetails();
        v=new Bike("B101","Yamaha",100,true);
        v.displayDetails();
    }
}