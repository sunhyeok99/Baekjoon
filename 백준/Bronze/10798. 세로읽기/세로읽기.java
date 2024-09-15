import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String[] arr = new String[5];
        
        for(int i = 0;i<5;i++){
            arr[i] = sc.next();            
        }
        String answer = "";
        for(int i = 0 ;i<15;i++){
            for(int j = 0;j<5;j++){
                if(arr[j].length() >= i+1){
                    answer += arr[j].substring(i,i+1);
                }
            }              
        }
        System.out.println(answer);
        
    }

}