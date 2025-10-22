import java.util.*;

class Solution {
    static ArrayList<Integer> ans;
    static int N, M;
    static int[][] arr;
    static boolean[][] flag;
    public int[] solution(String[] maps) {
        // 각 섬에서 몇일씩 머물수 있는지 확인
        // 각 섬 머물수 있는 날은 4방향칸 숫자 합한 값
        
        // 섬을 하나 만나면 그대로 bfs or dfs를 통해 점수 계산하고 방문처리
        N = maps.length;
        M = maps[0].length();
        arr = new int[N][M];
        for(int i = 0 ; i < N ; i ++){
            String line = maps[i];
            for(int j = 0 ; j < M ; j++){
                String tmp = line.substring(j,j+1);
                if(!tmp.equals("X")){
                    arr[i][j] = Integer.parseInt(tmp);
                }
            }
        }
        // 이제 탐색시작
        flag = new boolean[N][M];
        ans = new ArrayList<>();
        for(int i = 0 ; i < N ; i ++){
            for(int j = 0 ; j < M ; j++){
                if(arr[i][j] > 0 && !flag[i][j]){
                    solve(i,j);
                }
            }
        }
        if(ans.size() ==0){
            int[] answer = new int[1];
            answer[0] = -1;
            return answer;
        }
        int[] answer = new int[ans.size()];
        for(int i = 0 ; i < ans.size();i++){
            answer[i] = ans.get(i);
        }
        Arrays.sort(answer);
        return answer;
    }
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    
    public static void solve(int i , int j){
        Queue<Integer> qx = new LinkedList<>();
        Queue<Integer> qy = new LinkedList<>();
        flag[i][j] = true;
        qx.add(i);
        qy.add(j);
        int sum = arr[i][j];
        while(qx.size()>0){
            int x = qx.poll();
            int y = qy.poll();
            for(int in = 0 ; in < 4 ; in++){
                int nx = x + dx[in];
                int ny = y + dy[in];
                if(nx >= N || ny>= M || nx <0 || ny <0 || arr[nx][ny] ==0 || flag[nx][ny]){
                    continue;
                }
                qx.add(nx);
                qy.add(ny);
                sum += arr[nx][ny];
                flag[nx][ny] = true;
            }
            
        }
        ans.add(sum);
        
    }
    
}