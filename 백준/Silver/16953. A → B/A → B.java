import java.util.*;

public class Main {

    static int N,M;
    static int ans;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        // 1. 2를 곱한다.
        // 2. 1을 오른쪽에 추가한다 -> 10을 곱하고 +1
        // N에서 dfs를 통해 두개수에 해당하는 수에 true 처리를 한다.

        // 10억이 최대값인데 거기서 10을 곱하면 long으로 해야할수도
        // 근데 반대로 가도된다. 만약 1로 끝나면 2번 , 짝수이면 1번 수행
        ans = -1;
        solve(M,0);
        System.out.println(ans);
    }

    public static void solve(int num, int cnt){
        if(num == N){
            ans = cnt +1;
            return;
        }
        // 만약 N보다 숫자 적어지면 return
        if(num < N){
            return;
        }
        // 2번 수행
        if(num%10 == 1){
            solve(num/10 , cnt+1);
        }
        // 1번 수행
        else if(num%2 ==0){
            solve(num/2 , cnt+1);
        }
        // 나머지는 가망성 없는 경우
        return;

    }
}
