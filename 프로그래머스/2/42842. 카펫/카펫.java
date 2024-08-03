import java.util.*;
// 2 53
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        // 높이는 3에서 1늘어날때마다 brown과 yellow가 같은 길이로 늘어남
        // 12  4 정사각형의 경우 n제곱 - (n-2)제곱 , (n-2) 제곱 
        // 일단 저 숫자중 정사각형 최소단위를 뺴고 
        
        // 두개를 뻈을때 둘중 하나라도 음수가 되는 그점까지 먼저 찾고
        // 해당 n-2로 남은 yellow개수를 나눠서 그만큼 가로 늘림
        int sum = brown + yellow;
        // 최소 3부터
        for(int i = 3;i<sum/2;i++){
            int w = i;
            int h = sum/w;
            // 이때 각항 -2를 곱한게 yellow 개수
            if((w-2)*(h-2) == yellow){
                answer[0] = h;
                answer[1] = w;
                break;
            }
        }
      
        
        return answer;
    }
}