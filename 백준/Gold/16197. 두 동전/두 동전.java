import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair {
    int x1, y1, x2, y2;

    public Pair(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }
}

public class Main {

    public static int n, m;
    public static int[] dx = {0, 0, -1, 1}, dy = {1, -1, 0, 0};
    public static char[][] arr;
    public static int[][][][] visited;
    public static Queue<Pair> q = new LinkedList<>();
    public static int x1, y1, x2, y2;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        boolean first = false;

        arr = new char[n][m];
        visited = new int[n][m][n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = str.charAt(j);
                if (str.charAt(j) == 'o') {
                    if (first) {
                        x2 = i;
                        y2 = j;
                        q.add(new Pair(x1, y1, x2, y2));
                        visited[x1][y1][x2][y2] = 1;
                    } else {
                        x1 = i;
                        y1 = j;
                        first = true;
                    }
                }
            }
        }
        bfs();
    }

    static public void bfs() {
        while (!q.isEmpty()) {
            Pair now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx1 = now.x1 + dx[i];
                int ny1 = now.y1 + dy[i];
                int nx2 = now.x2 + dx[i];
                int ny2 = now.y2 + dy[i];

                int flag = 0;
                if (nx1 < 0 || nx1 >= n || ny1 < 0 || ny1 >= m) {
                    flag++;
                }
                if (nx2 < 0 || nx2 >= n || ny2 < 0 || ny2 >= m) {
                    if (flag == 1)
                        continue;
                    else if (flag == 0)
                        success(now);
                }
                if (flag == 1) {
                    success(now);
                } else if (flag == 2) {
                    continue;
                }

                if (arr[nx1][ny1] == '#') {
                    nx1 = now.x1;
                    ny1 = now.y1;
                }
                if (arr[nx2][ny2] == '#') {
                    nx2 = now.x2;
                    ny2 = now.y2;
                }

                if (visited[nx1][ny1][nx2][ny2] == 0) {
                    visited[nx1][ny1][nx2][ny2] = visited[now.x1][now.y1][now.x2][now.y2] + 1;
                    q.add(new Pair(nx1, ny1, nx2, ny2));
                }
            }
        }
        System.out.println(-1);
    }

    static public void success(Pair now) {
        if (visited[now.x1][now.y1][now.x2][now.y2] > 10)
            System.out.println(-1);
        else
            System.out.println(visited[now.x1][now.y1][now.x2][now.y2]);
        System.exit(0);
    }
}