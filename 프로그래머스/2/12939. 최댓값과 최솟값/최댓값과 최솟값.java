class Solution {
    public String solution(String s) {
        String answer = "";      
        int min = Integer.MAX_VALUE;
        int max = -1 * Integer.MAX_VALUE;
        String arr[] = s.split(" ");
        for(int i = 0;i<arr.length;i++){
            int num = Integer.parseInt(arr[i]);
            
            if(num > max){
                max = num;
            }
            if(num < min){
                min = num;
            }
        }
        answer = Integer.toString(min)+" "+Integer.toString(max);
        return answer;
    }
}