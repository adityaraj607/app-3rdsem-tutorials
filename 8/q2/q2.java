class FoodTask extends Thread {
    public FoodTask(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("Thread Name: " + getName() + " - Priority: " + getPriority());
        System.out.println(getName() + " is performing its task");
    }
}

public class q2 {
    public static void main(String[] args) {
        FoodTask orderProcessing = new FoodTask("OrderProcessing");
        FoodTask deliveryTracking = new FoodTask("DeliveryTracking");
        FoodTask notification = new FoodTask("Notification");

        orderProcessing.setPriority(3);
        deliveryTracking.setPriority(2);
        notification.setPriority(1);

        orderProcessing.start();
        deliveryTracking.start();
        notification.start();
    }
}
