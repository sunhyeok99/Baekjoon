import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        TreeSet<String> log = new TreeSet<String>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n ; i++) {
            String[] data = br.readLine().split(" ");
            if (data[1].equals("enter")) {
                log.add(data[0]);
            }
            else if(data[1].equals("leave")) {
                log.remove(data[0]);
            }
        }
        Iterator<String> iter = log.descendingIterator();
        while(iter.hasNext()) {
            bw.write(iter.next().toString());
            bw.newLine();
        }
        bw.flush();
    }  
}