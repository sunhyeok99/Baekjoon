import java.util.*;

public class Main {

    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        String s = sc.next();
       int ans = 0;
        for(int i = 0; i < N; i++) {
           ans += Integer.parseInt(s.substring(i,i+1));
       }

        System.out.println(ans);
    }

}
