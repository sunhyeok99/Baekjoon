import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,M;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N =Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        // 거리를 크게 하려면 남은 공유기들 사이의 거리를 이분탐색으로 몇이어야 하는지 선택?
        arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        int ans = 0;
        // 입력받은 좌표를 오름차순 정렬하고, 첫 번째 집에 공유기를 설치한 상태에서 시작한다.
        //1. 최소거리 t를 설정한다.
        //2. i번째 공유기를 설치한 집으로부터 t 이상의 거리를 두고 있는 집 중, 가장 가까운 집에 i+1번째 공유기 설치한다.
        //3. 마지막 집까지 2번 과정을 반복한 뒤에 설치된 공유기 수를 확인한다.

        int high = arr[N-1] - arr[0]+1;
        int low = 1;
        // 거리를 이분탐색으로 정한다음에 해당 거리보다 이상인 위치에 공유기를 설치하고
        // 최종 공유기의 개수가 몇개인지 count -> 개수가 많거나 같으면 거리 늘려야함 = low를 늘림(최대한 거리가 높은게 정답이라 같아도 여기에 포함)
        // count가 적다면 high을 줄려서 최소거리 줄임
        while(low <= high){
            int mid = (low + high)/2;
            // 해당 거리의 공유기 개수 count
            // 우선 1번은 무조건 설치
            int pos = 0;
            int cnt =1;
            for(int i = 1;i<N;i++){
                // i번쨰 설치
                // 만약 두개 거리가 mid이상이어야만 공유기 설치
                if(arr[i] - arr[pos] >= mid){
                    cnt ++;
                    pos = i;
                }
            }
            // 반복하면 총 count 개수가 나옴
            if(cnt >= M){
                // 개수가 많다 = 거리가 좁다 -> 거리 늘림
                ans = mid;
                low = mid +1;
                continue;
            }
            high = mid-1;
        }
        // // 설치한 수 == 가지고 있는 수가 되었을 때 while문을 끝내지 않고
        //        // 설치한 수 < 가지고 있는 수가 될 때가 되었을 때 끝냈기 때문에
        //        // 최소 거리의 최대(조건을 부합하지 않기 직전) 값을 출력하기 위해 1을 빼준다
        System.out.println(ans);

    }
}