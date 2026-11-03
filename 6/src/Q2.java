public class Q2{
    interface Payment{
        void pay(double amount);
    }
    static class CreditCardPayment implements Payment{
        public void pay(double amount){
            System.out.println("Credit Card Payment: "+amount);
        }
    }
    static class UPIPayment implements Payment{
        public void pay(double amount){
            System.out.println("UPI Payment: "+amount);
        }
    }
    static class NetBankingPayment implements Payment{
        public void pay(double amount){
            System.out.println("Net Banking Payment: "+amount);
        }
    }
    public static void main(String[]args){
        Payment p;
        p=new CreditCardPayment();
        p.pay(1000);
        p=new UPIPayment();
        p.pay(2000);
        p=new NetBankingPayment();
        p.pay(3000);
    }
}