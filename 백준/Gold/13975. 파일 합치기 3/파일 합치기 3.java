import java.util.*;

public class Main {

    static int N;
    static long ans;
    static PriorityQueue<Long> pq;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for(int t = 0; t < T; t++) {
         // 모두다 pq에 넣은다음
         // pq에서 2개씩 뽑아서 진행하면 될듯?
            // 대신 사이즈가 2이상일때만 뽑고 1개라면 그대로 정답출력
            pq = new PriorityQueue<>();
            N = sc.nextInt();
            for(int i = 0 ; i < N ; i++) {
                pq.add((long)sc.nextInt());
            }
            ans = 0;
            // 이제 2개씩 뽑는과정 진행
            while(pq.size() > 1){
                long a = pq.poll();
                long b = pq.poll();
                long sum = a + b;
                pq.add(sum);
                ans += sum;
            }
            // 이제 마지막 하나는 파일 최종본이라 끝
            System.out.println(ans);
       }


    }

}
