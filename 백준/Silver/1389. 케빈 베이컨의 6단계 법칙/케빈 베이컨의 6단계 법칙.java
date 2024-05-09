import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());   // 사람의 수
        int m = Integer.parseInt(st.nextToken());   // 관계의 수

        int[][] matrix = new int[n + 1][n + 1]; // 그래프를 표현할 2차원 배열

        for (int i = 1; i <= n; i++) {
            // Floyd-Warshall 알고리즘은 인접하지 않은 노드로 가는 비용의 초기값을 INF(무한대)로 잡아준다.
            Arrays.fill(matrix[i], n);
            matrix[i][i] = 0;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            matrix[s][e] = 1;   // 인접 노드는 비용이 1
            matrix[e][s] = 1;   // 방향이 없는 그래프이므로 반대로도 저장한다.
        }

        System.out.println(Floyd_Warshall(matrix));
    }

    private static int Floyd_Warshall(int[][] arr) {
        int[] baconNum = new int[arr.length];   // 각 사람의 베이컨 수를 저장할 배열

        for (int m = 1; m < arr.length; m++) {  // 거쳐가는 중간 노드
            for (int s = 1; s < arr.length; s++) {  // 시작 노드
                for (int e = 1; e < arr.length; e++) {  // 목적 노드
                    /*
                    시작 노드 s에서 목적 노드 e로 가는 최단거리를 구하기 위해서
                    s와 e 사이의 모든 노드 m에 대해 현재 arr[s][e]에 저장된 값과 arr[s][m] + arr[m][e]를 비교하며
                    arr[s][m] + arr[m][e]가 더 작다면 arr[s][e]값을 그 값으로 바꿔준다.
                    */
                    if (arr[s][e] > arr[s][m] + arr[m][e]) {
                        arr[s][e] = arr[s][m] + arr[m][e];
                    }
                }
            }
        }

        int minNum = 1; // 베이컨 수가 가장 작은 사람의 번호를 저장할 변수
        for (int i = 1; i < baconNum.length; i++) {
            for (int j = 1; j < baconNum.length; j++) {
                if (i != j) {   // 베이컨 수 = 자기 자신을 제외한 모든 사람과의 베이컨 게임 값을 더한다.
                    baconNum[i] += arr[i][j];
                }
            }
            minNum = (baconNum[i] < baconNum[minNum]) ? i : minNum;
        }

        return minNum;
    }

}