import java.util.Scanner;
 
public class Main {
    static int N;
    static int min;
    static int[][] arr;
    static boolean[] flag;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       
        N = sc.nextInt();
        arr = new int[N+1][N+1];
        for(int i=1;i<=N;i++) {
            for(int j=1;j<=N;j++) {
                arr[i][j] = sc.nextInt();
            }
        }       
        min =100000;    
        flag = new boolean[N+1];
             
        solve(1,0); 
         
        System.out.println(min);
        
 
    }
    static void solve(int x, int count) {
        // N/2개 팀 선정 끝
        if(count==N/2) {            
            min(); // 최소값 출력
            return;
        }
  
        for(int i = x; i <= N; i++) {
            // check가 안되어있으면
            if(!flag[i]) {
                flag[i] = true; // true로 변경
                solve(i+1, count+1);    
                flag[i] = false;    // 끝나면 false로
            }
        }
    }
  
    // 두 팀의 능력치 차이를 계산하는 함수 
    static void min() {
        int first = 0;
        int second = 0;
  
        for (int i = 1; i <= N - 1; i++) {
            for (int j = i + 1; j <= N; j++) {
                // check된팀은 first
                if (flag[i] == true && flag[j] == true) {
                    first += arr[i][j];
                    first += arr[j][i];
                }
                // check 안된팀은 second 
                else if (flag[i] == false && flag[j] == false) {
                    second += arr[i][j];
                    second += arr[j][i];
                }
            }
        }       
        int tmp = Math.abs(first - second); 
        if(tmp<min) {
            min = tmp;
        }
        if (min == 0) {         
            return;
        }       
             
    }
  
 
}