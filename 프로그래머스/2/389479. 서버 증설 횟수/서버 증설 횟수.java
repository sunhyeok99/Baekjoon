import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        // m명 늘어날 때마다 서버 하나를 증설해야하고 그 서버는 k시간만큼 지속
        // --> 최소 몇번 증설해야하는지
        
        int now = 0;
        // now는 증설된 서버 수로 k시간이 지나면 줄음
        // 큐를 만들어서 생성된 시간을 기록해 k만큼 지나면 제거
        Queue<Integer> q = new LinkedList<>();
        for(int i =0; i < players.length;i++){
            // 우선 현재 서버 만료된거 제거
            // System.out.println(i +" "+ q.size()+" "+q.peek());
            if(q.size() > 0 && q.peek() + k <= i){
                while(!q.isEmpty() && q.peek() + k <= i ){
                    q.poll();
                }
            }
            // 만료된 서버 제거했으니 현재 player 만족하는지 판단하고
            // 만족하지 않으면 서버 추가
            int cnt = players[i];
            if(cnt >= m * (q.size()+1)){
                int tmp = (cnt - m * q.size())/ m;
                for(int in = 0 ; in < tmp; in ++){
                    q.add(i);
                }
                // 증설횟수만큼 i를 추가하고 answer에 증설횟수추가
                answer += tmp;
            }
            
        }
        
        
        return answer;
    }
  
    
}