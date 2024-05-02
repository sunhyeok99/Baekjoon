import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static Edge[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken()); // 노드 개수
        int m = Integer.parseInt(stk.nextToken()); // 엣지 개수
        graph = new Edge[m + 1];
        long[] dist = new long[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int i = 0; i < m; i++) {
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            int w = Integer.parseInt(stk.nextToken());
            graph[i] = new Edge(a, b, w);
        }

        // 벨만 - 포드 알고리즘 O(VE)
        dist[1] = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Edge now_edge = graph[j];
                if (dist[now_edge.st] != Integer.MAX_VALUE &&
                        dist[now_edge.end] > dist[now_edge.st] + now_edge.cost) {
                    dist[now_edge.end] = dist[now_edge.st] + now_edge.cost; // update
                }
            }
        }
        // 음수 사이클 판별하기
        boolean cycle = false;
        for(int i = 0 ; i < m; i++){
            Edge now_edge = graph[i];
            if (dist[now_edge.st] != Integer.MAX_VALUE &&
                    dist[now_edge.end] > dist[now_edge.st] + now_edge.cost) {
                cycle = true;
            }
        }
        if(cycle){
            // 음수 사이클이 존재하면
            bw.write("-1\n");
        } else {
            // 음수 사이클이 존재하지 않으면
            for(int i = 2; i <= n; i++){
                if(dist[i]==Integer.MAX_VALUE)
                    bw.write(-1+"\n");
                else bw.write(dist[i]+"\n");
            }
        }
        bw.flush();
        bw.close();
    }

    static class Edge {
        int st;
        int end;
        int cost;

        public Edge(int s, int e, int c) {
            this.st = s;
            this.end = e;
            this.cost = c;
        }
    }
}