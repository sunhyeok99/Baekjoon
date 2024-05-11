import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Main {
    static int result = Integer.MIN_VALUE;
    static int[][] quest;
    static int n,m,k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        quest = new int[m][k];
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<k;j++){
                quest[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        search(0,1, 0);
        bw.write(String.valueOf(result));	//최대 퀘스트 완료 개수 BufferedWriter 저장
        bw.flush();		//결과 출력
        bw.close();
        br.close();
    }
    static void search(int idx, int cur, int bit){
        if(idx == n){
            check(bit);
            return;
        }
        if(cur > 2 * n){
            return;
        }
        search(idx+1, cur+1, bit | (1<<cur));
        search(idx, cur+1, bit);
    }
    static void check(int bit){
        int cnt = 0;
        for(int i=0;i<m;i++){
            boolean flag = false;
            for(int j=0;j<k;j++){
                if(((1<<quest[i][j]) & bit) == 0){
                    flag = true;
                    break;
                }
            }
            if(!flag){
                cnt++;
            }
        }
        result = Math.max(result, cnt);
    }
}

