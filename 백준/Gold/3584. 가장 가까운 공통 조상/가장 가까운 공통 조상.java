import java.util.*;

public class Main {

    static int N,M;
    static int[] arr;
    static boolean[] flag;
    static int ans;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for(int t = 0; t < T; t++) {
            N = sc.nextInt();
            arr = new int[N+1];
            for(int i = 0 ; i < N-1;i++){
                int a = sc.nextInt();
                int b = sc.nextInt();
                arr[b] = a;
            }
            // 각각 노드에 부모 노드를 저장해놓자

            // 구할 두개의 숫자
            int a = sc.nextInt();
            int b = sc.nextInt();
            ans = 0;
            // a의 부모에 해당하는 숫자를 모두 true로 바꾼후
            // b에서 거슬러 올라가면서 가장먼저 만나는 숫자?
            flag = new boolean[N+1];
            dfs(a);
            flag[a] = true;
            dfs2(b);
            System.out.println(ans);
        }


    }
    public static void dfs(int num){
        if(num == 0){
            return;
        }
        int tmp = arr[num];
        flag[tmp] = true;
        dfs(tmp);
    }
    public static void dfs2(int num){
        if(flag[num]){
            ans = num;
            return;
        }
        dfs2(arr[num]);
    }
}
