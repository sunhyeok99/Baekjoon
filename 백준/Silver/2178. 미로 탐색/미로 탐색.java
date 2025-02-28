import java.util.*;

public class Main {

    static int N, M;
    static int[][] arr;
    static int ans;
    static class node{
        int x;
        int y;
        int cnt;
        node(int x, int y, int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    static Queue<node> q;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N][M];
        for(int i = 0; i < N; i++) {
            String line = sc.next();
            for(int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(line.substring(j, j+1));
            }
        }

        // bfs시작
        ans = Integer.MAX_VALUE;
        solve();
        System.out.println(ans);
    }
    static int dx[] = {-1,1,0,0};
    static int dy[] = {0,0,1,-1};
    public static void solve() {
        q = new LinkedList<>();
        q.add(new node(0,0,1));
        boolean[][] visited = new boolean[N][M];
        while(!q.isEmpty()) {
            node n = q.poll();
            if(n.x == N-1 && n.y == M-1) {
                ans = Math.min(ans, n.cnt);
                continue;
            }
            // 방문확인 + 백트래킹
            if(visited[n.x][n.y] || n.cnt >= ans) {
                continue;
            }
            visited[n.x][n.y] = true;
            for(int idx = 0; idx < 4; idx++) {
                int nx = n.x + dx[idx];
                int ny = n.y + dy[idx];
                if(nx < 0 || ny < 0 || nx >= N || ny >= M || arr[nx][ny] == 0 || visited[nx][ny]) {
                    continue;
                }
                q.add(new node(nx, ny, n.cnt+1));
            }
        }


    }


}