import java.util.Scanner;
class BankAccount {
    private int accountNumber;
    private String accountHolder;
    private double balance;
    BankAccount(int accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }
    void deposit(double amount) {
        balance += amount;
    }
    void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient balance");
        }
    }
    void display() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: ₹" + balance);
    }
}
public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Account Number: ");
        int accountNumber = sc.nextInt();
        sc.nextLine();
        System.out.print("Account Holder: ");
        String accountHolder = sc.nextLine();
        System.out.print("Initial Balance: ");
        double balance = sc.nextDouble();
        BankAccount account = new BankAccount(accountNumber, accountHolder, balance);
        System.out.print("Deposit Amount: ");
        double deposit = sc.nextDouble();
        account.deposit(deposit);
        System.out.print("Withdraw Amount: ");
        double withdraw = sc.nextDouble();
        account.withdraw(withdraw);
        account.display();
    }
}