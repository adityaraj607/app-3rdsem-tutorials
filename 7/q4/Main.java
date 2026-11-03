class BankTask implements Runnable {
    public void run() {
        String name = Thread.currentThread().getName();
        try {
            for (int i = 1; i <= 3; i++) {
                System.out.println(name + ": " + name + " activity - Execution " + i);
                if (name.equals("TransactionProcessing"))
                    Thread.sleep(1000);
                else if (name.equals("BalanceUpdating"))
                    Thread.sleep(1500);
                else
                    Thread.sleep(2000);
            }
        } catch (InterruptedException e) {
            System.out.println(name + " interrupted");
        }
    }
}
public class Main {
    public static void main(String[] args) {
        BankTask task = new BankTask();
        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        Thread t3 = new Thread(task);
        t1.setName("TransactionProcessing");
        t2.setName("BalanceUpdating");
        t3.setName("SMSNotification");
        t1.start();
        t2.start();
        t3.start();
    }
}
