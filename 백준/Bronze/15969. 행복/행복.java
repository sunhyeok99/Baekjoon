import java.util.Scanner;
import java.util.Arrays;
 
 
public class Main {
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        
        int[] scores = new int[N];
        
        for (int i = 0; i < N; i++) {
            scores[i] = sc.nextInt();
        }
        
        int difference = calculateScoreDifference(scores);
        
        System.out.println(difference);
    }
    
    private static int calculateScoreDifference(int[] scores) {
        Arrays.sort(scores);
        
        int difference = scores[scores.length -1] - scores[0];
        
        return difference;
    }
    
}