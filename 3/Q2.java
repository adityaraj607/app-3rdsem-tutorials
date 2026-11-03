import java.util.Scanner;
public class Q2 {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        int[] attendance = new int[7];
        for (int i=0;i<7;i++){
            int att = sc.nextInt();
            attendance[i]=att;
        }

        int presentdays=0;
        for (int i:attendance){
            if(i==1) presentdays++;
        }
        if(((presentdays/7)*100)>=75){
            System.out.println("Eligible for Exam");
        }else{
            System.out.println("Not Eligible");
        }
    }
}
