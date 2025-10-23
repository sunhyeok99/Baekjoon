import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        int answer = -1;
        // 1. n 더함 , 2. 2곱함, 3. 3곱함
        // 각각 bfs로 뻗어나가면서 그 수보다 커지면 끝내면될듯
        Queue<node> q = new LinkedList<>();
        q.add(new node(x, 0));
        boolean[] flag = new boolean[1000001];
        flag[x] = true;

        while(q.size()>0){
            node now = q.poll();
            if(now.num == y){
                answer = now.cnt;
                break;
            }
            // 3개 각각 진행
            int nx = now.num + n;
            if(nx <= 1000000 && !flag[nx]){
                q.add(new node(nx, now.cnt+1));
                flag[nx] = true;
            }
            nx = now.num * 2;
            if(nx <= 1000000 && !flag[nx]){
                q.add(new node(nx, now.cnt+1));
                flag[nx] = true;
            }
            nx = now.num * 3;
            if(nx <= 1000000 && !flag[nx]){
                q.add(new node(nx, now.cnt+1));
                flag[nx] = true;
            }           
            
        }
        
        return answer;
    }
    static class node{
        int num, cnt;
        node(int num, int cnt){
            this.num = num;
            this.cnt = cnt;
        }
    }
}