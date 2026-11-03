import java.util.Scanner;
class Candidate {
    int candidateId;
    String name;
    int aptitude;
    int technical;
    int communication;
    Candidate(int candidateId, String name, int aptitude, int technical, int communication) {
        this.candidateId = candidateId;
        this.name = name;
        this.aptitude = aptitude;
        this.technical = technical;
        this.communication = communication;
    }
    int getTotalScore() {
        return aptitude + technical + communication;
    }
}
public class Q6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        Candidate[] candidates = new Candidate[n];
        for (int i = 0; i < n; i++) {
            int id = sc.nextInt();
            String name = sc.next();
            int aptitude = sc.nextInt();
            int technical = sc.nextInt();
            int communication = sc.nextInt();
            candidates[i] = new Candidate(id, name, aptitude, technical, communication);
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (candidates[j].getTotalScore() < candidates[j + 1].getTotalScore() ||
                        (candidates[j].getTotalScore() == candidates[j + 1].getTotalScore() &&
                                candidates[j].candidateId > candidates[j + 1].candidateId)) {
                    Candidate temp = candidates[j];
                    candidates[j] = candidates[j + 1];
                    candidates[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < k; i++) {
            System.out.println(candidates[i].candidateId + " " +
                    candidates[i].name + " " +
                    candidates[i].getTotalScore());
        }
    }
}