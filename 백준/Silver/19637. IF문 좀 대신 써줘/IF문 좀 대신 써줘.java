import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {

    static int m;
    static int n;
    static List<Item> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s, " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            s = br.readLine();
            st = new StringTokenizer(s, " ");
            list.add(new Item(st.nextToken(), Integer.parseInt(st.nextToken())));
        }

        for (int i = 0; i < m; i++) {
            s = br.readLine();
            sb.append(list.get(binarySearch(Integer.parseInt(s))).name).append('\n');
        }

        System.out.println(sb.toString().trim());
    }

    static int binarySearch(int stat) {

        int userStat = stat;
        int left = 0;
        int right = list.size() - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (userStat <= list.get(mid).value) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return right + 1;
    }

    static class Item {
        String name;
        int value;

        public Item(String name, int value) {
            this.name = name;
            this.value = value;
        }
    }
}