import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
//        String st = br.readLine();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum=0;
//        int max=0;
        for(int i=0;i<N;i++) {
//            arr[i] = Integer.parseInt(st.split(" ")[i]);
            arr[i] = Integer.parseInt(st.nextToken());
//            if(arr[i]>max) max = arr[i];
        }
        int tBud = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
            int lo = 0;
            int hi = arr[N-1];
            int mid =0; int ans=0;
            while(true) {
                mid = (lo + hi)/2;
                sum=0;
                for(int i=0;i<N;i++) {
//                    if(arr[i]<mid) {
//                        sum += arr[i];
//                    }else {
//                        sum += mid;
//                    }
                    sum += Math.min(arr[i], mid);
                }
                
                if(sum>tBud) hi = mid-1;
                else if(sum == tBud){
                	ans = mid;
                	break;
                }
//                if(sum<tBud) {
                else {
                    lo = mid+1;
                }
                if(lo>hi) {
                	ans = hi;
                	break;
                }
            }
            System.out.println(ans);
    }//main
}