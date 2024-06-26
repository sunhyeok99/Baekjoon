class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for(int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                answer[i] = numbers[i] + 1;
                continue;
            }
            
            String line = "0" + Long.toBinaryString(numbers[i]);
            
            for (int j = line.length() - 1; j >= 0; j--) {
                if (line.charAt(j) == '0') {
                    String word = line.substring(0, j) + "10" + line.substring(j + 2);
                    answer[i] = Long.parseLong(word, 2);
                    break;
                }
                
                if (j == 0) {
                    answer[i] = Long.parseLong("10" + line.substring(2), 2);
                }
            }
        }
        
        return answer;
    }
}
