import java.util.*;
import java.io.*;

class Solution {
    static int[][] arr;
    static int n;
    static int m;
    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        // 남은 컨테이너수 return
        // 한글자가 들어오면 0이랑 닿은부분 제거
        // 두글자들어오면 모두 제거
        
        // 알파벳은 -64제거한 숫자로 count -> A는 1부터
         n = storage.length;
         m = storage[0].length();
        arr = new int[n][m];
        for(int i = 0 ; i < n ; i ++){
            for(int j = 0 ; j < m ; j ++){
                arr[i][j] = (storage[i].charAt(j) - 64);
            }
        }
        // 이제 입력하나씩 받아보자
        for(int i = 0 ; i < requests.length;i++){
            String word = requests[i];
            if(word.length() == 1){
                solve1(word.charAt(0) - 64);
            }
            else{
                solve2(word.charAt(0) - 64);
            }
             
        }
         for(int i = 0 ; i < n ; i ++){
            for(int j = 0 ; j < m ; j ++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        
        // 개수 count
        for(int i = 0 ; i < n ; i ++){
            for(int j = 0 ; j < m ; j ++){
                if(arr[i][j] != 0){
                    answer ++;
                }
            }
        }
        
        return answer;
    }
    
    public static void solve1(int num){
        // 겉에가 0인 숫자 제거
        Queue<Integer> qx = new LinkedList();
        Queue<Integer> qy = new LinkedList();
        // 해당점이 안쪽점에 영향미칠수 있으므로 한번에 저장후 제거
        for(int i = 0 ; i < n ; i ++){
            for(int j = 0 ; j < m ; j ++){
                if(arr[i][j] == num){
                   // 이 점이 0에 둘러쌓여있는지 판단
                    if(find(i,j)){
                        qx.add(i);
                        qy.add(j);
                    }
                }
            }
        }     
        while(qx.size() >0){
            int a = qx.poll();
            int b = qy.poll();
            arr[a][b] = 0;
        }
        
    }
    
    public static void solve2(int num){
        // 전체에서 num 제거
        for(int i = 0 ; i < n ; i ++){
            for(int j = 0 ; j < m ; j ++){
                if(arr[i][j] == num){
                    arr[i][j] = 0;
                }
            }
        }        
    }
    public static boolean find(int i, int j){
        // 해당 점이 창고 외부랑 연결되었는지 확인
        // 해당지점에서 bfs를 실행해서 맨끝에있는 0인 점에 도달하는지 확인
        Queue<Integer> qx = new LinkedList();
        Queue<Integer> qy = new LinkedList();
        qx.add(i);
        qy.add(j);
        boolean[][] visited = new boolean[n][m];
        while(qx.size() > 0){
            int x= qx.poll();
            int y = qy.poll();
            if(x == 0 || y == 0 || x == n-1 || y == m-1){
                return true;
            }
            
            for(int in = 0 ; in < 4; in ++){
                int nx = x + dx[in];
                int ny = y + dy[in];
                if(nx <0 || ny <0 || nx >= n || ny>= m || arr[nx][ny] !=0 || visited[nx][ny]){
                    continue;
                }
                visited[nx][ny] = true;
                qx.add(nx);
                qy.add(ny);
                
            }
            
        }
        
        return false;
        
    }
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    
}