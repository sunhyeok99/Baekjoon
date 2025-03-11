import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] arr;
    public static void main(String[] args) throws IOException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine());        // 투포인터 써보자
        arr = new int[N+1];
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(reader.readLine());

        for(int i = 1; i <= N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        M = Integer.parseInt(reader.readLine());
        for(int i = 1; i <= M;i++){
            // 투포인터 진행
            st = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            boolean flag = false;
            while(a < b){
                if(arr[a] != arr[b]){
                    flag = true;
                    break;
                }
                a++;
                b--;
            }

            if(flag){
                sb.append("0\n");
            }
            else{
                sb.append("1\n");
            }

        }

            System.out.println(sb);






    }



}