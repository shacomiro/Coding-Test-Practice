import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int[] check;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] minDist;	//DFS
    static int[] dis;		//BFS

    // 최단 거리를 구할 때는 BFS가 권장되므로 지양해야 함.
    public void dfs(int v, int goal, int dist) {
        if(v == goal) minDist[goal] = Math.min(minDist[goal], dist);
        else {
            for(int nv : graph.get(v)) {
                if(check[nv] == 0) {
                    check[nv] = 1;
                    dfs(nv, goal, dist + 1);
                    check[nv] = 0;
                }
            }
        }
    }

    // 최단 거리는 BFS를 이용.
    public void BFS(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);
//        int L = 0; // 레벨은 숙제
        check[v] = 1;
        dis[v] = 0;

        while(!queue.isEmpty()) {
            int len = queue.size();

            for(int i = 0; i < len; i++) {
                int cv = queue.poll();

                for(int nv : graph.get(cv)) {
                    if(check[nv] == 0) {
                        check[nv] = 1;
                        queue.offer(nv);
                        dis[nv] = dis[cv] + 1;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st1.nextToken());
        check = new int[n + 1];
        for(int i = 0; i <= n; i++) graph.add(new ArrayList<>());
        minDist = new int[n + 1];
        dis = new int[n + 1];
        for(int i = 0; i <= n; i++) minDist[i] = Integer.MAX_VALUE;
        m = Integer.parseInt(st1.nextToken());
        for(int i = 0; i < m; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());
            graph.get(a).add(b);
        }

//        check[1] = 1;
        T.BFS(1);
        for(int i = 2; i <= n; i++) {
//            T.dfs(1, i, 0);
//            System.out.println(i + " : " + minDist[i]);
            System.out.println(i + " : " + dis[i]);
        }

    }
}
