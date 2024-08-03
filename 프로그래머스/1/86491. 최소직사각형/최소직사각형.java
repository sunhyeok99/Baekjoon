class Solution {
    public int solution(int[][] sizes) {
        // 최소값이 나오게 하려면 
        // 한쪽이 짧고 다른 한쪾은 길게
        int a = 0 ;
        int b= 0;
        for(int i = 0 ;i<sizes.length;i++){
            int w = sizes[i][0];
            int h = sizes[i][1];
            // 두개중 최대값이 b로 최소값이 a로 가게 설정
            a = Math.max(a, Math.min(w,h));
            b = Math.max(b, Math.max(w,h));
        }
        
        
        return a*b;
    }
}