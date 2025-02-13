import java.util.*;

public class Main {

    static int N, M, R, max;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        R = sc.nextInt();
        // 최대한 휴게소간 거리의 최대값이 짧게
        // 이분탐색
        arr = new int[N+2];
        arr[0] = 0;
        arr[N+1] = R;
        for(int i =1 ;i<=N;i++){
            arr[i] = sc.nextInt();
        }
        // 이분탐색 시작
        int left = 1;
        int right = R-1;
        Arrays.sort(arr);
        // mid 값을 휴게소 간의 최대 거리로 가정하고 이분탐색 돌리자. -> mid 값이 곧 정답
        while(left<=right){
            int mid = (left + right) / 2;
            int sum = 0;
            // 현재 mid 값을 기준으로 휴게소를 얼마나 추가해야 하는지 계산
            for(int i=1; i<arr.length; i++) {
                sum+=(arr[i] - arr[i-1] - 1) / mid;
            }
            // 추가할 휴게소가 너무 많음 → mid 증가 (더 넓은 간격 허용)
            if(sum > M) {
                left = mid+1;
            }
            // 가능한 경우 → mid를 줄여 더 작은 간격 찾기
            else {
                right = mid-1;
            }
        }
        System.out.println(left);


    }


}
