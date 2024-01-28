import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.*;
import java.util.*;
 
 
public class Main {
 
    static int n,m;
    static long []sum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
 
        String[] s1 = br.readLine().split(" ");
 
        sum = new long[m];
        int [] arr = new int[n];
        arr[0] = Integer.parseInt(s1[0])%m;
        sum[arr[0]]++;
        long result =0;
 
        for(int i=1; i<n; i++){
            int num = Integer.parseInt(s1[i]);
            arr[i]+=(arr[i-1]+num)%m;
            sum[arr[i]%m]++;
        }
 
        result+=((sum[0]*(sum[0]+1))/2);
 
        for(int i=1; i<m; i++){
            result+=(((sum[i]-1)*(sum[i]))/2);
        }
 
        System.out.println(result);
    }
}