import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N;
	static long[] arr;
    public static void main(String[] args) throws IOException {
    	Scanner sc = new Scanner(System.in);
    	N = sc.nextInt();
    	arr = new long[N];
    	for(int i =0;i<N;i++) {
    		arr[i] = sc.nextInt();
    	}
    	long max = sc.nextLong();
    	// 약간 이거 
    	// 일단 정렬해가지고 
    	// 허용되는 숫자랑 넘는숫자 두개가지고
    	// 이분탐색 하는 느낌
    	
    	// 일단 정렬
    	Arrays.sort(arr);
    	// 정렬해서 일단 더하다가 안넘는 범위랑 
    	// 넘어가는 범위를 구해보자 
    	long lo = 0;
    	long hi = arr[N-1];
    	// 2분탐색으로 index 사이를 구해보자
    	long middle = 0;
    	while(true) {
    		middle = (lo + hi)/2;
    		
    		long sum = 0;
    		for(int i =0;i<N;i++) {
    			long tmp = Math.min(arr[i], middle);
    			sum += tmp;
    		} 
//    		System.out.println(sum+" "+middle);
    		if(sum == max) {
    			break;
    		}
    		else if(sum>max) {
    			hi = middle-1;
    		}
    		else {
    			lo = middle +1;
    		}
    		
    		if(lo>hi) {
    			middle = hi;
    			break;
    		}
    		
    	}
    	
    	System.out.println(middle);
    	
    	
    }
}