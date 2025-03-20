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
        M = sc.nextInt();
        arr = new int[N];
        int arr2[] = new int[M];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < M; i++) {
            arr2[i] = sc.nextInt();
        }
        // 두개모두 정렬후 arr에서 하나잡고 이분탐색 매번돌려보자
        Arrays.sort(arr);
        Arrays.sort(arr2);
        long a = 0;
        long b = 0;
        for(int i = 0; i < N; i++) {
            int num = arr[i];
            // num이 arr2에서 뭐보다 크고 적은지 확인해보자
            int left = 0;
            int right = M-1;
            int idx = -1;
            // 우선 밑에 들어갈 개수부터 구하자
            while(left <= right) {
                int mid = (left + right) / 2;
                if(num > arr2[mid]) {
                    left = mid + 1;
                    idx = mid;
                }
                else{
                    right = mid-1;
                }
            }
            a += idx+1;

            left = 0;
            right = M-1;
            idx = -1;
            while(left<= right) {
                int mid = (left + right) / 2;
                if(num >= arr2[mid]) {
                    left = mid + 1;
                    idx = mid;
                }
                else{
                    right = mid-1;
                }
            }
            b+= M - idx-1;
        }
            System.out.println(a+" "+b+" "+ ((long)N*M-(a+b)));

    }
}