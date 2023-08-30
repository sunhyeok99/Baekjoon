import java.util.Scanner;
 
public class Main { 
    static int N ;
    static int K;
    static int[] arr;
    static int count;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
      
         N = sc.nextInt();
        K = sc.nextInt();
        arr = new int[N];
        for(int i=0;i<N;i++) {
            arr[i] = sc.nextInt();
        }
         
        count = 0;
         
        solve(0,0);
        if(K==0){
            count--;
        }
        System.out.println(count);
         
        
    }
    public static void solve(int x, int sum) {
        // 4까지 갔을때 총합이 K랑 같은지 확인
        if(x == N) {            
//          System.out.println(x+" "+sum);
            if(sum==K) {                
                count++;                
            }
            return;
        }
        solve(x+1,sum+arr[x]); // 이번것을 포함할때
        solve(x+1,sum); // 포함하지 않을때
    }
}