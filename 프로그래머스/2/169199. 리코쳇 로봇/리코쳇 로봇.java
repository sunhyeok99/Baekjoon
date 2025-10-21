import java.util.*;

class Solution {
    static int answer;
    static int N;
    static int M;
    static int[][] arr;
    static int ansN;
    static int ansM;
    static Queue<node> q = new LinkedList<>();
    static boolean[][] flag;
    public int solution(String[] board) {
        answer = -1;
        N = board.length;
        M = board[0].length();
        arr = new int[N][M];
        
        ansN = 0;
        ansM = 0;
        flag = new boolean[N][M];
        for(int i = 0 ; i < N;i++){
            String line = board[i];
            for(int j = 0 ; j< M ; j++){
                String tmp = board[i].substring(j,j+1);
                if(tmp.equals("D")){
                    arr[i][j] = 2;
                }
                else if(tmp.equals("R")){
                    q.add(new node(i,j,0));
                    flag[i][j] = true;
                }
                else if(tmp.equals("G")){
                    ansN = i;
                    ansM = j;
                }
            }
        }
        // 실행
        solve();
        
        return answer;
    }
    
    static class node{
        int x, y, cnt;
        node(int x, int y, int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    
    static void solve(){
        while(q.size() >0){
            node n = q.poll();
            if(n.x == ansN && n.y == ansM){
                answer = n.cnt;
                return;
            }
            // 4방향 탐색하여 추가
            // 움직이는게 벽만날때까지
             // 4방향 탐색
            for (int dir = 0; dir < 4; dir++) {
                int nx = n.x;
                int ny = n.y;

                // 한 방향으로 쭉 이동 (벽 또는 경계 전까지)
                while (true) {
                    int tx = nx + dx[dir];
                    int ty = ny + dy[dir];

                    if (tx < 0 || ty < 0 || tx >= N || ty >= M) break; // 경계 밖
                    if (arr[tx][ty] == 2) break; // 벽(D) 만나면 멈춤

                    nx = tx;
                    ny = ty;
                }

                // 멈춘 위치가 아직 방문 안했으면 큐에 추가
                if (!flag[nx][ny]) {
                    flag[nx][ny] = true;
                    q.add(new node(nx, ny, n.cnt + 1));
                }
            }           
            
        }
        
        
        
    }
    
}