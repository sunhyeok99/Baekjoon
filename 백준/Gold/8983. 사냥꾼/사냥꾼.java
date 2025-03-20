import java.util.*;

public class Main {
    static class node implements Comparable<node>{
        int x;
        int y;
        node(int x, int y){
            this.x = x;
            this.y = y;
        }
        public int compareTo(node o){
            return this.x - o.x;
        }
    }
    static int N,M;
    static int[] arr;
    static PriorityQueue<node> q;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N+1];
        int L = sc.nextInt();

        for(int i = 0;i < N;i++) {
            arr[i] = sc.nextInt();
        }
        arr[N] = arr[N-1];
        q = new PriorityQueue<>();
        for(int i = 0;i < M;i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            q.add(new node(a,b));
        }
        Arrays.sort(arr);
        // 하나씩 꺼내면서 비교
        int ans = 0;
       for(int i = 0;i <= N;i++) {
           int pos = arr[i];
            while(q.size()!=0){
                node n = q.peek();
                if(Math.abs(n.x - pos) + n.y <= L){
                    // 사정거리 안
                    q.poll();
                    ans ++;
                }
                else{
                    // 만약 x 좌표가 가까운데 거리가 먼경우
                    if(i != N && (Math.abs(arr[i+1] - n.x) >= Math.abs(arr[i] - n.x))){
                        q.poll();
                        continue;
                    }
                    break;
                }
            }
       }

        System.out.println(ans);

    }
}