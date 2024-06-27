class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        // 선물 가장많이 받는다는 것은 선물지수가 낮다 -> 주고 못받음
        
        // 선물주면 지수 -1 , 받으면 +1 
        int[][] price = new int[friends.length][friends.length];
        // 1번이 2번에게 주면 price[1][1] -- , price[1][2] -- , price[2][1] ++ 이렇게 기록
        for(int i = 0;i<gifts.length;i++){
            String[] tmp = gifts[i].split(" "); // 앞에가 주는사람 뒤가 받는사람
            String give = tmp[0];
            String receive = tmp[1]; 
            int giveIdx = -1;
            int receiveIdx = -1;
            // 각각 배열에서 찾아서 지수 바꾸자
            for(int j = 0;j<friends.length;j++){
                if(friends[j].equals(give)){
                    giveIdx = j;
                }
                if(friends[j].equals(receive)){
                    receiveIdx = j;
                }
            }
            // 번호 찾았으니 지수 이제 변환
            price[giveIdx][giveIdx] --;
            price[giveIdx][receiveIdx] --;
            price[receiveIdx][giveIdx] ++;
            price[receiveIdx][receiveIdx] ++;
        }
        // 이제 다 돌면서 2중for문으로 
        // 선물 많이 받을 사람 찾자
        for(int i = 0 ;i<friends.length;i++){
            int ans = 0;
            for(int j = 0;j<friends.length;j++){
                System.out.println(i+" "+j+" "+price[i][i] +" "+price[i][j]+" "+price[j][i]);
                if(i==j) continue;
                // 받는 조건 -> 그사람보다 더 많이 받았어야하며 , 같다면 지수가 낮아야함
                if(price[i][j] < price[j][i] || (price[i][j] == price[j][i] && price[i][i] < price[j][j])){
                    ans ++;
                }
            } 
            // i번째 사람이 받을 지수 구했으니 이제 max값 갱신
            answer = Math.max(ans , answer);
        }
        
        return answer;
    }
}