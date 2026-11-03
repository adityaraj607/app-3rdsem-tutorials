class ExamTask implements Runnable {
    public void run() {
        String name = Thread.currentThread().getName();
        try {
            if (name.equals("Timer")) {
                for (int i = 5; i >= 1; i--) {
                    System.out.println(name + ": Remaining time = " + i + " minutes");
                    Thread.sleep(1000);
                }
            } else if (name.equals("AutoSave")) {
                for (int i = 1; i <= 3; i++) {
                    System.out.println(name + ": Saving student answers...");
                    Thread.sleep(2000);
                }
            } else if (name.equals("NetworkCheck")) {
                for (int i = 1; i <= 3; i++) {
                    System.out.println(name + ": Checking network connection...");
                    Thread.sleep(1500);
                }
            }
        } catch (InterruptedException e) {
            System.out.println(name + " interrupted");
        }
    }
}
public class Main {
    public static void main(String[] args) {
        ExamTask task = new ExamTask();
        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        Thread t3 = new Thread(task);
        t1.setName("Timer");
        t2.setName("AutoSave");
        t3.setName("NetworkCheck");
        t1.start();
        t2.start();
        t3.start();
    }
}
