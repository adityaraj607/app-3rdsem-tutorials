class TrafficJunction extends Thread {
    public TrafficJunction(String name) {
        setName(name);
    }
    public void run() {
        try {
            for (int i = 1; i <= 3; i++) {
                System.out.println(getName() + ": Traffic Status - " +
                        (i == 1 ? "Low" : i == 2 ? "Moderate" : "Heavy") +
                        " (Report " + i + ")");
                if (getName().equals("Junction1"))
                    Thread.sleep(1000);
                else if (getName().equals("Junction2"))
                    Thread.sleep(1500);
                else
                    Thread.sleep(2000);
            }
        } catch (InterruptedException e) {
            System.out.println(getName() + " interrupted");
        }
    }
}
public class Main {
    public static void main(String[] args) {
        TrafficJunction t1 = new TrafficJunction("Junction1");
        TrafficJunction t2 = new TrafficJunction("Junction2");
        TrafficJunction t3 = new TrafficJunction("Junction3");
        t1.start();
        t2.start();
        t3.start();
    }
}