package Account;
public class SavingsAccount extends Account{
    public SavingsAccount(String accountNumber,double balance){
        super(accountNumber,balance);
    }
    public void displayDetails(){
        System.out.println("Savings "+accountNumber+" "+balance);
    }
}