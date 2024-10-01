import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        // 맨 앞에서부터 다 모아놓고
        // 만약 첫날에 4일 그담날 2 , 4 ,6 나오면 6나온날전까진 모두 리스트에 한번에 추가
        // --> 반대로 모든 리스트의 진도를 계산해놓고 모두 큐에추가 후 하나씩 꺼내면서
        // max값보다 적은값나오면 값 +1하면서 제일 큰값나오면 현재값 리스트에 추가 후 다음값으로 이동하면됨
        Queue<Integer> q = new LinkedList<Integer>();
        
        for(int i = 0 ;i<progresses.length;i++){
            int tmp = (100 - progresses[i]) / speeds[i];
            // 만약 나머지있으면 +!
            if((100- progresses[i]) % speeds[i] != 0) {
                tmp++;
            }
            q.add(tmp);
        }
                
        ArrayList<Integer> ar = new ArrayList<>();
        int num = q.poll();
        int cnt = 1;
        while(q.size()>0){
            // 맨위것보다 크거나 같으면 cnt+1
            // 만약 작으면 num 교체후에 cnt는 1로 초기화
            if(num >= q.peek()){
                q.poll();
                cnt++;
            }
            else{
                ar.add(cnt);
                num = q.poll();
                cnt = 1;
            }
        }
        // 모두 끝난후 현재 cnt 값도 추가
        ar.add(cnt);
        int[] answer = new int[ar.size()];
        for(int i = 0 ;i<answer.length;i++){
            answer[i] = ar.get(i);
        }
        
        return answer;
    }
}