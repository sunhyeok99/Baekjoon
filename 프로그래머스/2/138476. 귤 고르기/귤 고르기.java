import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        // k개의 귤을 담았을 때 귤 무게의 종류가 최솟값이 되어야함 
        // 해쉬맵 -> 정렬이 되나?
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i = 0 ; i < tangerine.length; i++){
            hm.put(tangerine[i] , hm.getOrDefault(tangerine[i] , 0) + 1);
        }
        // 다 넣은 후에 우선순위 큐? 에 다가 넣고 뽑기?
        // 근데 사실 name은 필요가 없고 숫자만 필요하긴하다.
        ArrayList<Integer> ar = new ArrayList<>();
        for(int key : hm.keySet()){
            int cnt = hm.get(key);
            ar.add(cnt);
        }
        // 정렬후 계산
        Collections.sort(ar);
        Collections.reverse(ar);
        int num = k;
        while(num > 0){
            num -= ar.get(0);
            ar.remove(0);            
            answer++;
        }
        
        return answer;
    }
//     static class node implements Comparable<node>{
//         String name;
//         int cnt;
//         node(String name, int cnt){
//             this.name = name;
//             this.cnt = cnt;
//         }
        
//         @Override
//         public int compareTo(node o){
//             return o.cnt - this.cnt;
//         }
//     }
}