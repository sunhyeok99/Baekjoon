import java.util.*;

public class Main {

    static int N, M;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        // 현재 맨앞에 한명을 넣고
        long result = 0;
        Stack<int[]> s = new Stack<>();

        for(int i=0; i<N; i++) {
            // 자신보다 키가 작은 경우 스택에서 pop
            while(!s.isEmpty() && s.peek()[0] < arr[i]) {
                result+= s.pop()[1];
            }

            if(s.isEmpty()) {
                s.push(new int[] {arr[i],1});
            }else {
                if(s.peek()[0] > arr[i]) {
                    s.push(new int[] {arr[i],1});
                    result++;
                } else {
                    result+= s.peek()[1]++;
                    if(s.size()>1) result++;
                }
            }
        }
        System.out.println(result);

    }

}