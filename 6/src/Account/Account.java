package Account;
public class Account{
    String accountNumber;
    double balance;
    public Account(String accountNumber,double balance){
        this.accountNumber=accountNumber;
        this.balance=balance;
    }
    public void displayDetails(){
        System.out.println(accountNumber+" "+balance);
    }
}