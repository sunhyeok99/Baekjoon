import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> present = new PriorityQueue<>(Collections.reverseOrder());

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(st.nextToken());
            present.offer(value);

        }
        st = new StringTokenizer(br.readLine(), " ");
        boolean flag = false;
        for (int i = 0; i < M; i++) {
            int child = Integer.parseInt(st.nextToken());
            if (present.peek() >= child) {
                present.offer(present.peek() - child);
                present.poll();
            } else {
                flag = true;
            }
        }

        if (flag == true) {
            sb.append("0");
        } else {
            sb.append("1");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}