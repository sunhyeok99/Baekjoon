import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,M;
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = sc.nextInt();
        }
        // 처음두개 계산하고
        // 왼쪽꺼를 움직였을때 값이 커지면 그상태에서 오른쪽꺼 이동, 적어지면 왼쪽꺼 또 이동?
        int left = 0;
        int right = N-1;

        int cnt = N-2;
        int sum = 0;
        while(cnt>0){
            sum = Math.max(sum, cnt * Math.min(arr[left] , arr[right]));
            if(arr[left] > arr[right]){
                right --;
            }
            else{
                left++;
            }
            cnt --;
        }
        System.out.println(sum);


    }
}