import java.util.*;

public class Main {

    static int N, M;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N+1];
        for (int i = 1; i <= N; i++) {
            arr[i] = sc.nextInt();
        }
        int[] price = new int[M+1];
        price[0] = 1;
        // arr에는 동전들의 값이, price에는 전체값이 들어있다.
        for(int i = 1; i <= N; i++) {
            for(int j = arr[0]; j<=M; j++){
                if(j<arr[i])
                    continue;
                // arr[i]번쨰원을 사용하지 않았을떄의 값을 더함
                // -> j원일 떄 가짓수 파악 가능
                price[j] += price[j-arr[i]];
            }
        }

        System.out.println(price[M]);

    }


}
