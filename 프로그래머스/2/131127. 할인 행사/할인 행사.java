import java.util.*;

class Solution {
    static String[] want;
    static int[] number;
    static String[] discount;
    static int answer;
    public int solution(String[] want, int[] number, String[] discount) {
        answer = 0;
        this.want = want;
        this.number = number;
        this.discount = discount;
        
        // 회원 가입시 10일 유지 - 하루에 제품 1개 구매
        // 원하는 제품 수량이 10일 연속 일치할 경우 회원가입
        
        // 14일이면 0,1,2,3,4일에 시작할때마다 가능한지 확인
        for(int i= 0; i < discount.length - 9; i++){
            solve(i);   
        }
        
        
        return answer;
    }
    public static void solve(int idx) {
        HashMap<String, Integer> hm = new HashMap<>();
        for(int i = 0 ; i < 10; i ++){
            hm.put(discount[idx + i] , hm.getOrDefault(discount[idx +i] , 0) + 1);
        }        
        // want 배열에서 확인
        for(int i = 0 ; i < want.length; i++){
            String word = want[i];
            if(hm.getOrDefault(word , 0 ) < number[i]){
                return;
            }
        }
        // 다만족하면 +1
        answer ++;
    }
    
    static class node{
        String name;
        int cnt;
    }
}