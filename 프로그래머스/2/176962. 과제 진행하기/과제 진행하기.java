import java.util.*;
import java.io.*;

class Solution {
    static PriorityQueue<node> pq = new PriorityQueue<node>();
    static PriorityQueue<node> ing = new PriorityQueue<node>();
    public String[] solution(String[][] plans) {
        ArrayList<String> ar = new ArrayList<>();
        // 과제 진행에서 새로 시작해야하면 새로운 과제 진행
        // 과제 다했을 때 멈춰둔 과제가 있으면 진행하지만 새로운과제가 있다면 새로운 과제부터
        // 멈춘과제가 여러개면 최근에 멈춘 과제 진행
        
        // plans는 name start playtime으로 구성
        // 큐를 이용해야할듯. node는 name, start, playtime, stop으로 시작안한애들은 60 * 60, 나머진 멈춘시간으로 저장
        for(int i = 0 ; i < plans.length; i++){
            String name = plans[i][0];
            int start = 60 * Integer.parseInt(plans[i][1].substring(0,2)) + Integer.parseInt(plans[i][1].substring(3,5));
            int playtime = Integer.parseInt(plans[i][2]);
            pq.add(new node(name, start ,playtime, 0));
        }
        int now = pq.peek().start; // 현재 시간
        
        // pq에서 시작해서 진행중인 애들은 ing로
        while(true){
            // 1. 현재 now값이 pq의 start보다 적다면 ing 확인해서 있으면 끝내고,
            // 2. 만약 ing가 없다면 now를 pq의 start로 바꾸고 진행
            // 3. 중간에 now값 + ing의 playtime값이 pq의 start보다 크다면 다시 ing에 추가하고 pq꺼 진행
            
            // 우선 pq꺼 먼저 소비하는거로 진행
            if(pq.size() == 0 ){
                // 0이 되게되면 ing꺼 모두 소비하면된다.
                while(true){
                    if(ing.size() ==0){
                        break;
                    }
                    ar.add(ing.poll().name);
                }
                break;
            }
       
            
            // 0이 아닐때는 ing 신경쓰면서 진행
            if(now < pq.peek().start){
                // ing 임시진행
                if(ing.size() >0){
                    // 1. 걸릴때 2. 안걸릴때
                    node n = ing.poll();
                    // 안걸리면 모두 진행 , 걸리면 조금더 진행하고 다시 추가
                    if(now + n.playtime <= pq.peek().start){
                        ar.add(n.name);
                        now += n.playtime;
                    }
                    else {
                        int time = pq.peek().start - now; // 진행시간
                        now = pq.peek().start;
                        ing.add(new node(n.name , 0, n.playtime - time, now));
                    }                
                }
                else{
                    // ing가 없으면 새로운거 진행
                    // now를 이동
                    now = pq.peek().start;
                }                
            }
            // pq꺼 진행
            else{
                node n = pq.poll();
                // 모두 진행
                if(pq.size() == 0){
                    ar.add(n.name);
                }
                else if(now + n.playtime <= pq.peek().start){
                    ar.add(n.name);
                    now += n.playtime;
                }
                // 중간에 걸리면 더하고 ing로
                else{
                    int time = pq.peek().start - now; // 진행시간
                    now = pq.peek().start;                    
                    ing.add(new node(n.name, 0, n.playtime - time, now));
                }                
            }
            
        }
        String[] answer = new String[ar.size()];
        for(int i = 0; i < ar.size(); i++){
            answer[i] = ar.get(i);
        }
        return answer;
    }
    static class node implements Comparable<node>{
        String name;
        int start;
        int playtime; // 남은시간도
        int stop;      
        node(String name, int start, int playtime, int stop){
            this.name = name;
            this.start = start;
            this.playtime = playtime;
            this.stop = stop;
        }
        // 한번시작한애들은 start를 0으로 저장하자
        
        @Override
        public int compareTo(node o){
            if(o.start == this.start){
                return o.stop - this.stop;
            }
            return this.start - o.start;
        }
        
    }
}