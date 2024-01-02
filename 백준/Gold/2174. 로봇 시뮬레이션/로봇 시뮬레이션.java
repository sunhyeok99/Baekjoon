import java.io.*;
import java.util.*;
public class Main {
    static int a,b,n,m;
    static int dx[] = {0,-1,0,1,0};
    static int dy[] =  {0,0,1,0,-1};
    static int map[][];
    static Robot robot[];
    static ArrayList<Order>list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String [] t = br.readLine().split(" ");
        a = Integer.parseInt(t[0]); //  map[0][a]
        b = Integer.parseInt(t[1]); // map[b][0]
        
        map = new int[b+1][a+1];
        String [] tt = br.readLine().split(" ");
        n = Integer.parseInt(tt[0]);        // 로봇의 개수
        m = Integer.parseInt(tt[1]);    // 명령의 개수
        
        robot = new Robot[n+1];
        
        for(int i=0; i<n; i++) {
            String [] input = br.readLine().split(" ");
            int y = Integer.parseInt(input[0]); // map[0][x]
            int x = Integer.parseInt(input[1]); // map[y][0]
            String str = input[2];  // 방향을 숫자로 변환 과정 거칠것
            int dir = change(str);
            map[(b-x)+1][y] = i+1;
            robot[i+1] = new Robot((b-x)+1,y,dir);
        }
        
        for(int i=0; i<m; i++) {
            String[] order_input = br.readLine().split(" ");
            int rn = Integer.parseInt(order_input[0]);
            String ro = order_input[1];
            int rc = Integer.parseInt(order_input[2]);
            list.add(new Order(rn,ro,rc));
        }

        solve();
    }
    public static void solve() {
        for(int i=0; i<list.size(); i++) {
            int cnt = list.get(i).cnt;  // 반복횟수
            int robot_num = list.get(i).num;    //로봇번호
            String order = list.get(i).str; // 명령종류
            for(int j=0; j<cnt; j++) {
                int tmp_dir = robot[robot_num].dir;
                int x = robot[robot_num].x;
                int y = robot[robot_num].y;
                switch(order) {
                case "L":
                    tmp_dir--;
                    if(tmp_dir==0) {
                        tmp_dir=4;
                    }
                    robot[robot_num].dir = tmp_dir;
                    break ;
                case "R":
                    tmp_dir++;
                    if(tmp_dir==5) {
                        tmp_dir=1;
                    }
                    robot[robot_num].dir = tmp_dir;
                    break ;
                case "F":
                    int tmp_x = x+dx[tmp_dir];
                    int tmp_y = y+dy[tmp_dir];
                    if(!isRange(tmp_x,tmp_y)) {
                        System.out.println("Robot "+robot_num+" crashes into the wall");
                        System.exit(0);
                    }
                    if(map[tmp_x][tmp_y]!=0) {
                        System.out.println("Robot "+robot_num+" crashes into robot "+map[tmp_x][tmp_y]);
                        System.exit(0);
                    }
                    map[x][y] =0;
                    map[tmp_x][tmp_y] = robot_num;
                    robot[robot_num].x = tmp_x;
                    robot[robot_num].y = tmp_y;
                    break;
                }
            }
        }
        System.out.println("OK");
    }
    public static boolean isRange(int x, int y) {
        if(x>=1 && y>=1 && x<=b && y<=a) {
            return true;
        }
        return false;
    }
    public static int change(String str) {
        switch(str){
            case "N":
                return 1;
            case "E":
                return 2;
            case "S":
                return 3;
            case "W":
                return 4;
        }
        return 1000;
    }
}
class Robot{
    int x,y,dir;
    Robot(int x, int y, int dir){
        this.x=x;
        this.y=y;
        this.dir=dir;
    }
}
class Order{
    int num,cnt;
    String str;
    Order(int num,String str,int cnt){
        this.num=num;
        this.cnt=cnt;
        this.str =str;
    }
}