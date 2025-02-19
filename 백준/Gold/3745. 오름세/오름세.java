import java.util.*;

public class Main {
// LIS 알고리즘
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true){
            if(!sc.hasNextInt()){
                break;
            }
            N =sc.nextInt();
            // 배열에서 상승세가 가장 긴 부분을 찾으면 된다.
            int[] stock = new int[N];
            int[] dp = new int[N];
            for (int i = 0; i < N; i++) {
                stock[i] = sc.nextInt();
            }
            // stock배열에서 하나씩 뽑아서
            // dp배열에 만약 해당 숫자가 연속으로 커지는 숫자면 들어갈 위치를 이분탐색으로 찾아서 넣고,
            // 그게 깨진다면 dp배열 초기화하여 해당 숫자만 저장
            dp[0] = stock[0];
            int lastIndex = 0;

            for (int i = 1; i < N; i++) {
                // 현재 선택숫자가 더 크면 index++해주고 값 교체
                if (dp[lastIndex] < stock[i]) {
                    lastIndex++;
                    dp[lastIndex] = stock[i];
                }
                // 현재 숫자가 적다면 들어갈 위치 파악해서 숫자 넣기
                else {
                    int index = findIndex(dp, stock[i], lastIndex);
                    dp[index] = stock[i];
                }
            }
            System.out.println(lastIndex + 1);
        }
    }

    public static int findIndex(int[] dp, int num, int lastIndex) {
        int left = 0;
        int right = lastIndex;

        while (left < right) {
            int mid = (left + right) / 2;
            if (dp[mid] == num) {
                return mid;
            }

            if (dp[mid] > num) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return right;
    }
}