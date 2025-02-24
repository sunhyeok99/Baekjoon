import java.util.*;

public class Main {
    static int N;
    static ArrayList<node>[] ar;
    static int[] energy;
    static int[] parent;
    static int[] ans;
    static class node{
        int next, cost;
        node(int next, int cost){
            this.next = next;
            this.cost = cost;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        N = sc.nextInt();
        // 모든방은 연결, n-1개의 통로 ----> 트리형태
        // 우선 모두 입력받은다음에 각 방의 부모 방을 찾고,
        // 각 방에서 시작해서 어디까지 갈 수 있는지 계산

        energy = new int[N+1];
        parent = new int[N+1];
        ans = new int[N+1];
        ar = new ArrayList[N+1];
        for(int i = 1; i <= N; i++){
            ar[i] = new ArrayList<>();
            energy[i] = sc.nextInt();
        }
        for(int i = 1; i < N; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int cost = sc.nextInt();
            ar[a].add(new node(b,cost));
            ar[b].add(new node(a,cost));
        }
        // 이제 각 부모의 방을 찾아보자
        dfs(0,1);

        // 각 부모 연결했으니 하나씩 어디까지 갈 수 있는지 확인
        for(int i = 1; i <= N; i++){
            int pos = solve(i, energy[i]);
            ans[i] = pos;
            System.out.println(ans[i]);
        }

    }

    public static void dfs(int prior, int now){
        for(int i = 0; i < ar[now].size(); i++){
            int tmp = ar[now].get(i).next;
            if(tmp == prior){
                continue;
            }
            parent[tmp] = now;
            dfs(now, tmp);
        }
    }

    public static int solve(int pos, int nowEnergy){
        // 해당 위치 pos에서 부모위치로 최대한 많이 가고
        // 갈 수 있는 최대의 부모 index 리턴
        int now = pos;
        while(true){
            // 다 갈 수 있음
            if(now == 1){
                return 1;
            }
            int parentNode = parent[now];
            int needEnergy = 0;
            // 연결된 지점에서 부모위치로 가는데 필요한 energy구함
            for(int i = 0; i < ar[now].size(); i++){
                int tmp = ar[now].get(i).next;
                if(tmp == parentNode){
                    // 부모위치 찾음
                    needEnergy = ar[now].get(i).cost;
                    break;
                }
            }
            // 저 에너지만큼 있다면 움직이고 없다면 끝냄
            if(nowEnergy < needEnergy){
                return now;
            }
            nowEnergy -= needEnergy;
            now = parentNode;
        }



    }

}