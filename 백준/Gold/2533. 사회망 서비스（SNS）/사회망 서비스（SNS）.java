import java.util.*;

public class Main {
    static int N;
    static ArrayList<Integer>[] ar;
    static int[][] dp;
    static int ans;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 일단 하나인것들은 찾아서 연결된 것과 true처리
        // 하나가 끝나면 이제 나머지 것들은 +1해줌
        N = sc.nextInt();
        ans = 0;
        ar = new ArrayList[N+1];
        for(int i = 1; i <= N; i++){
            ar[i] = new ArrayList<>();
        }
        for(int i = 1; i <= N-1; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            ar[a].add(b);
            ar[b].add(a);
        }

        // 얼리어답터 선정 or 비선정
        dp = new int[N+1][2];
        solve(0,1);
        System.out.println(Math.min(dp[1][0], dp[1][1]));

    }
    public static void solve(int parent, int x){
        // 여기가 얼리어답터 일경우에는 다음 브랜치가 상관없고,
        // 아니면 다음 브랜치는 무조건 얼리어답터 이어야한다.
        dp[x][1] =1;

        for(int i = 0; i < ar[x].size(); i++){
            int nx = ar[x].get(i);
            if(nx == parent){
                continue;
            }
            solve(x, nx);
            // 다음거는 무조건 얼리어답터
            dp[x][0] += dp[nx][1];
            // 상관없음
            dp[x][1] += Math.min(dp[nx][0] , dp[nx][1]);
        }


    }

}