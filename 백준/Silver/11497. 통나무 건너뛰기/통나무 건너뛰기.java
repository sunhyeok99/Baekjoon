

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T;i++){
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2-o1);
            int[] arr = new int[N];
            for(int j=0; j<N;j++){
                queue.add(Integer.valueOf(st.nextToken()));
            }
            arr[N/2]=queue.poll();
            int left = N/2-1;
            int right = N/2+1;
            while(!queue.isEmpty()){
                if(right<N){
                arr[right++]=queue.poll();}
                if(!queue.isEmpty()){
                arr[left--]=queue.poll();}
            }
            int max = Math.abs(arr[0]-arr[N-1]);
            for(int j=1; j<N;j++){
               max = Math.max(max,Math.abs(arr[j]-arr[j-1]));
            }
            System.out.println(max);
        }
    }

}