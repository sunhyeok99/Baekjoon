import java.io.IOException;
import java.util.*;

public class Main {
    static class node{
        int x;
        int y;
        int day;
        node(int x,int y,int day){
            this.x=x;
            this.y=y;
            this.day=day;
        }
    }
    static int[][] arr;
    static Queue<Integer> qx;
    static Queue<Integer> qy;
    static Queue<node> q;
    static boolean[][] flag;
    static int ans;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        arr = new int[8][8];
        // 시작위치 7,0
        // 목표위치 0,7
        qx = new LinkedList<>();
        qy = new LinkedList<>();
        // 가능한 움직임 - 왼쪽, 왼쪽위, 위, 오른쪽위, 오른쪽, 가운데
        // 모든 벽은 우선 큐에넣고 하나씩 빼서 -1한 위치로 해보자
        for(int i = 0 ; i < 8;i++){
            String line = sc.next();
            for(int j = 0 ; j < 8; j++){
                String tmp = line.substring(j,j+1);
                if(!tmp.equals(".")){
                    arr[i][j] = 1;
                    qx.add(i);
                    qy.add(j);
                }
            }
        }
        q = new LinkedList<>();
        flag = new boolean[8][8];
        q.add(new node(7,0,0));
        ans = 0;
        solve();
        System.out.println(ans);
    }
    public static int[] dx = {0,1,1,1,0,0,-1,-1,-1};
    public static int[] dy = {-1,-1,0,1,1,0,1,0,-1};
    // 좌표를 꺼내서 해당 좌표가 값이 1일 경우(벽이 내려와서 낀경우) 제거,
    // 0일 경우에는 주변에 움직일 수 있는 곳 탐색해서 이동하고 좌표 true처리?
    public static void solve(){
    // 시작지점에서 시작
        while(!q.isEmpty()) {
            flag = new boolean[8][8];
            // 정답이 달라질 수도 있어 매 횟수마다 방문 배열은 초기화
            int size = q.size();
            for (int t = 0; t < size; t++) {
                node n = q.poll();
                if (!foundWall() || (n.x == 0 && n.y == 7)) {
                    ans = 1;
                    return;
                }
                if (arr[n.x][n.y] == 1) {
                    continue;
                }

                // 이동
                for (int in = 0; in < dx.length; in++) {
                    int nx = n.x + dx[in];
                    int ny = n.y + dy[in];
                    if (nx >= 0 && nx < 8 && ny >= 0 && ny < 8 && arr[nx][ny] == 0 && !flag[nx][ny]) {
                        // 조건을 다 만족한다면 저장
                        flag[nx][ny] = true;
                        q.add(new node(nx, ny, 0));
                    }

                }

            }
            // 1턴이 끝나면 벽이 내려옴
            moveWall();
        }
    }
    // 벽이 위에서 하나씩 떨어지는 구조
    static void moveWall() {
        for (int i=7; i>=0; i--) {
            for (int j=0; j<8; j++) {
                if (arr[i][j] == 1) {
                    arr[i][j] = 0;
                    if (i != 7) {
                        arr[i+1][j] = 1;
                    }
                }
            }
        }
    }
    // 벽이 있는지 탐색 -> 만약 맵 전체에 벽이 없다면 그대로 1 출력하고 끝내도된다.
    static boolean foundWall() {
        for (int i=0; i<8; i++) {
            for (int j=0; j<8; j++) {
                if (arr[i][j] == 1){
                    return true;
                }
            }
        }
        return false;
    }


}