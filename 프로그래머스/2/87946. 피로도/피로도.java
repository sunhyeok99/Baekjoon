class Solution {
    static int k;
    static int ans;
    static boolean[] flag;
    static int cnt; // 던전의 개수
    static int[] arr;
    public int solution(int k, int[][] dungeons) {
        ans = 0;
        this.k = k;
        // 최소 필요 피로도보다 많아야 던전을 돌 수 있으며 
        // 유저가 탐험할 수 있는 최대 던전수 RETURN
        
        // k로 피로도가 주어지면 dungeons의 배열에서 하나씩 던점 탐험해서 최대를 알아내자
        // 모든 경로를 이용해서 수행해서 최대값 찾자
        cnt = dungeons.length;
        flag = new boolean[cnt];
        arr = new int[cnt];
        dfs(0,dungeons);
        
        return ans;
    }
    public void dfs(int index , int[][] dungeons){
        if(index == cnt){
            // cnt의 개수만큼 던전 순서를 정했으면 
            // arr배열 상대로 계산
            // for(int i = 0;i<cnt;i++){
            //     System.out.print(arr[i] +" ");
            // }
            //     System.out.println();
            solve(dungeons);
            return;
        }
        
        for(int i = 0;i<cnt;i++){
            if(flag[i]){
                continue;
            }
           flag[i] = true;
            arr[index] = i;
            dfs(index+1 , dungeons);
            flag[i] = false;
        }
        return;
    }
    
    public void solve(int[][] dungeons){
        // arr배열에 적힌 순서대로 
        // 피로도 계산해보자
        int possible = 0;
        int health = k;
        for(int i = 0;i<cnt;i++){
            // arr의i번째 최소 피로도보다 크다면 
            // 소모 피로도 만큼 감점시킨다.
            if(health >= dungeons[arr[i]][0]){
                health -= dungeons[arr[i]][1];
                possible++;
            }
        }
        // 모든 것 다 수행했을 때 최대값 갱신
        ans = Math.max(ans, possible);
        return;
        
    }
}