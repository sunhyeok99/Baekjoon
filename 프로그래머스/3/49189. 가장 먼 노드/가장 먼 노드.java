import java.util.*;

class Solution {
    static List<List<Integer>> adj;
    static int[] count;
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        count = new int[n+1];
        adj = new ArrayList<>(n+1);
        
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        
        // 간선 정보로부터 인접 리스트를 생성합니다.
        for (int[] e : edge) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        count[1] = 1;  // 시작 노드의 count를 1로 설정합니다.
        
        int max = 0;
        
        while (!q.isEmpty()) {
            int current = q.poll();
            for (int neighbor : adj.get(current)) {
                if (count[neighbor] == 0) {
                    count[neighbor] = count[current] + 1;
                    max = Math.max(max, count[neighbor]);
                    q.add(neighbor);
                }
            }
        }
        
        // 최대 거리를 가지는 노드의 개수를 셉니다.
        for (int i = 2; i <= n; i++) {
            if (count[i] == max) {
                answer++;
            }
        }
        
        return answer;
    }
}
