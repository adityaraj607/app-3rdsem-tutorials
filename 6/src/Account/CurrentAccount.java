package Account;
public class CurrentAccount extends Account{
    public CurrentAccount(String accountNumber,double balance){
        super(accountNumber,balance);
    }
    public void displayDetails(){
        System.out.println("Current "+accountNumber+" "+balance);
    }
}