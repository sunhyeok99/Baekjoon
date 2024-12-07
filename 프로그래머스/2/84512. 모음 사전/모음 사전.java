class Solution {
    static int answer;
    static int cnt;
    public int solution(String word) {
        answer = 0;
        // 우선적으로 하나의 글자에서 총 나올수 있는 가짓수는 1562/2
        
        // dfs로 하나씩ㄷ ㅓ하면서 +1    
        solve("", word);
        
        
        return answer;
    }
    public static void solve(String word , String ans){
        if(word.length() > 5){
            return;
        }
        if(word.equals(ans)){
            answer = cnt;
        }
        
        
        cnt ++;
        solve(word+"A", ans);
        solve(word+"E", ans);
        solve(word+"I", ans);
        solve(word+"O", ans);
        solve(word+"U", ans);
        
    }
}