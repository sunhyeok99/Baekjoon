import java.io.*;
import java.util.*;
public class Main {
    static int n,m;
    static int arr[][];
    static int ans = 0;
    static boolean visited[][];
    static boolean sector_visited[];
    static int sector_arr[][];
    static int dx[] = {0,0,1,-1};
    static int dy[] = {1,-1,0,0};
    static int dir[];
    static ArrayList<Integer>size_list = new ArrayList<>();
    static ArrayList<Node>one_list = new ArrayList<>(); //1을 담을 장소
    static ArrayList<Node>zero_list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] t  = br.readLine().split(" ");
        
        n = Integer.parseInt(t[0]);
        m = Integer.parseInt(t[1]);
        
        arr = new int[n][m];
        sector_arr = new int[n][m];
        
        visited = new boolean[n][m];
        for(int i=0; i<n; i++) {
            String[] tt = br.readLine().split(" ");
            for(int j=0; j<m; j++) {
                arr[i][j]=Integer.parseInt(tt[j]);
                if(arr[i][j]==1) {
                    one_list.add(new Node(i,j));
                }
                else {
                    zero_list.add(new Node(i,j));
                }
            }
        }
        size_list.add(0);   // 구역은 1번 구역부터 시작하니  인덱스 통일하기 위해서 0번째 size_list에 필요없는 값 넣음
        int sector=1;
        
        for(int i=0; i<one_list.size(); i++) {
            Node a = one_list.get(i);
            if(!visited[a.x][a.y]) {
                sector_bfs(a.x,a.y,sector);
                sector++;
            }
        }
    
        sector_visited = new boolean[sector+1];
        
        for(int i=0; i<zero_list.size(); i++) {
            Node a = zero_list.get(i);
            dir = new int[4];
            solve(a.x,a.y);
        }
        System.out.println(ans);
    }
    public static void solve(int x, int y) {
        int tmp=1;
        for(int i=0; i<4; i++) {
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(isRange(nx,ny)&& arr[nx][ny]==1) {
                int group_num = sector_arr[nx][ny]; // nx,ny과 몇번 그룹인지 얻어냄
                if(!sector_visited[group_num]) {            // 이 그룹의 첫 방문이라면
                    tmp+=size_list.get(group_num);      // 이 그룹의 1개수를 더해줌
                    sector_visited[group_num] = true;   // 그리고 이 그룹 방문처리
                }
            }       // 만약 이미 방문한 그룹이라면 중복때문에 갈 필요가 없겠죠? 그래서 위에 과정이 있는겁니다
        }
        
        
        for(int i=0; i<4; i++) {        
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(!isRange(nx,ny)) {
                continue;
            }
            sector_visited[sector_arr[nx][ny]]=false;
        }
        ans = Math.max(ans, tmp);
    }
    public static  void sector_bfs(int x, int y, int sector) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x,y));
        int cnt = 1;
        sector_arr[x][y]=sector;
        visited[x][y]=true;
        while(!q.isEmpty()) {
            Node a = q.poll();
            for(int i=0; i<4; i++) {
                int nx = a.x+dx[i];
                int ny= a.y+dy[i];
                if(isRange(nx,ny) && !visited[nx][ny] && arr[nx][ny]==1) {
                    q.add(new Node(nx,ny));
                    visited[nx][ny]=true;
                    sector_arr[nx][ny]=sector;
                    cnt ++;
                }
            }
        }
        size_list.add(cnt);
    }
    public static boolean isRange(int x, int y) {
        if(x>=0 && y>=0 && x<n && y<m) {
            return true;
        }
        else {
            return false;
        }
    }
}
class Node{
    int x,y;
    Node(int x, int y){
        this.x=x;
        this.y=y;
    }
}