public class Q3{
    interface BasicSecurity{
        void login();
        void logout();
    }
    interface AdvancedSecurity extends BasicSecurity{
        void fingerprint();
        void faceRecognition();
    }
    static class BankingApplication implements AdvancedSecurity{
        public void login(){
            System.out.println("Login");
        }
        public void logout(){
            System.out.println("Logout");
        }
        public void fingerprint(){
            System.out.println("Fingerprint Authentication");
        }
        public void faceRecognition(){
            System.out.println("Face Recognition Authentication");
        }
    }
    public static void main(String[]args){
        AdvancedSecurity b=new BankingApplication();
        b.login();
        b.fingerprint();
        b.faceRecognition();
        b.logout();
    }
}