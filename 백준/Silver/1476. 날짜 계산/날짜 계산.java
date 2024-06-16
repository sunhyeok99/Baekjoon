import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int e = 1, s = 1, m = 1;
        int answer = 1;

        while (true) {
            if (e == E && s == S && m == M) {
                break;
            }
            answer++;
            e++;
            if (e > 15) {
                e=1;
            }
            s++;
            if (s > 28) {
                s=1;
            }
            m++;
            if (m > 19) {
                m=1;
            }
        }
        System.out.println(answer);

    }
}