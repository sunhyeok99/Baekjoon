import java.util.*;

public class Main {

    static int N, M;
    static int[][] arr;
    static int[] paper;
    static boolean[][] visit;
    static int ans;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 10x10에서 각 0과 1을 입력을 받고
        // 1이 시작되는 위치에서 총 몇x몇인지 파악해서 개수에서 +1씩 하자
        // 중간에 하나가 5가되면 그대로 끝
        arr = new int[10][10];
        paper = new int[6];
        visit = new boolean[10][10];
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        ans = Integer.MAX_VALUE;
        DFS(0, 0);
        if(ans == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }

        System.out.println(ans);
    }

    static void DFS(int depth, int cnt) {
        if(depth == 100) {
            ans = Math.min(ans, cnt);
            return;
        }

        int r = depth / 10;
        int c = depth % 10;

        if(arr[r][c] == 0 || visit[r][c])
            DFS(depth + 1, cnt);
        else {
            for(int i=1;i<=5;i++) {
                if(check(r, c, i, true)) {
                    DFS(depth + 1, cnt + 1);
                    check(r, c, i, false);
                }
            }
        }
    }

    // flag가 true면 색종이를 붙이는 경우, false면 떼는 경우
    static boolean check(int r, int c, int num, boolean flag) {
        if(flag) {
            if(paper[num] == 5)
                return false;

            // 붙일 수 있는지 확인
            for(int i=r;i<r+num;i++) {
                for(int j=c;j<c+num;j++) {
                    if(i >= 10 || j >= 10 || visit[i][j] || arr[i][j] == 0)
                        return false;
                }
            }

            paper[num]++;
        }
        else{
            paper[num]--;
        }

        // 색종이 붙이거나 떼기
        for(int i=r;i<r+num;i++)
            for(int j=c;j<c+num;j++)
                visit[i][j] = flag;

        return true;
    }

}