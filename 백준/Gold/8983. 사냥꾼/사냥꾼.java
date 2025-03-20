import java.util.*;

public class Main {
    static int N,M;
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N];
        int L = sc.nextInt();

        for(int i = 0;i < N;i++) {
            arr[i] = sc.nextInt();
        }
        int[][] animal = new int[M][2];
        for(int i = 0;i < M;i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            animal[i][0] = a;
            animal[i][1] = b;
        }
        Arrays.sort(arr);
        // 하나씩 꺼내면서 비교
        int ans = 0;

        for(int i = 0 ; i < M;i++){
            // 동물하나를 잡고 이분탐색을 통해 사정거리 안에 들어가는 지 판단
            // 들어가면 다음 동물 / 안들어가면 될때까지
            int a = animal[i][0];
            int b = animal[i][1];
            int left = 0;
            int right = N-1;
            while(left <= right){
                int mid = (left + right) / 2;
                if(Math.abs(arr[mid] - a) + b <= L){
                    ans ++;
                    break;
                }
                // 사정거리 안에 들어가면 ans++

                // x좌표가 arr기준 어디위치하는지에 따라 이동
                // x좌표가 더 적다면 arr을 낮추고 / 더 크다면 left를 올려서 기준올림
                if(a < arr[mid]){
                    right = mid -1;
                }
                else{
                    left = mid +1;
                }
            }
        }


        System.out.println(ans);

    }
}