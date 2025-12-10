import java.util.*;
import java.io.*;

public class Main {
    static int N, M, K;
    static int ans;
    static int[] arr;
    static int[][] map;
    static boolean[] visited;
    static boolean[][] flag;
    static int[] dp;
    static int[] selected;
    static ArrayList<Integer>[] ar;
    static int ansX, ansY;
    static PriorityQueue<Integer> q;
    static int tmp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 입력
        N = Integer.parseInt(br.readLine());

        ar = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            ar[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            ar[a].add(b);
            ar[b].add(a);
        }

        // DFS
        ans = 0;
        visited = new boolean[N + 1];
        dfs(1, 0);

        String result = (ans % 2 == 1) ? "Yes" : "No";
        System.out.println(result);
    }

    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};

    public static void dfs(int st, int cnt) {
        visited[st] = true;

        // 연결된 노드 탐색
        for (int i = 0; i < ar[st].size(); i++) {
            int nxt = ar[st].get(i);
            if (!visited[nxt]) {
                dfs(nxt, cnt + 1);
            }
        }

        // leaf node
        if (st != 1 && ar[st].size() == 1) {
            ans += cnt;
        }
    }
}
