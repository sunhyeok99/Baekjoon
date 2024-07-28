import java.util.*;
class Solution {
    
    public class Point implements Comparable<Point> {
        int node, cost;
        
        public Point(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Point o) {
            return this.cost - o.cost;
        }
    }
    
    public List<List<Point>> map = new ArrayList<>();
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        for(int i = 0; i < n; i++) {
            map.add(new ArrayList<>());
        }
        for (int i = 0; i < costs.length; i++) {
            int from = costs[i][0];
            int to = costs[i][1];
            int val = costs[i][2];
            map.get(from).add(new Point(to, val));
            map.get(to).add(new Point(from, val));
        }
        //Prim Algorithm
        boolean[] visited = new boolean[n];
        PriorityQueue<Point> queue = new PriorityQueue<>();
        queue.add(new Point(0, 0));
        while(!queue.isEmpty()) {
            Point cur = queue.poll();
            
            if(visited[cur.node]) continue;
            visited[cur.node] = true;
            answer += cur.cost;
            
            for(int i = 0; i < map.get(cur.node).size(); i++) {
                int next = map.get(cur.node).get(i).node;
                int cost = map.get(cur.node).get(i).cost;
                if(visited[next]) continue;
                queue.add(new Point(next, cost));
            }
        }
        return answer;
    }
}