import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int answer = 0;
    static int n;
    static int m;
    static int[] check;
    static ArrayList<ArrayList<Integer>> graph;
    //정점의 갯수가 많아지면(1만개 이상) 배열이 아닌 ArrayList를 사용해야 메모리 낭비와 시간 낭비를 줄일 수 있다.

    public void dfs(int v) {
        if(v == n) answer++;
        else {
            for(int nv : graph.get(v)) {
                if(check[nv] == 0) {
                    check[nv] = 1;
                    dfs(nv);
                    check[nv] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st1.nextToken());
        graph = new ArrayList<>();
        for(int i = 0; i <= n; i++) graph.add(new ArrayList<>());
        check = new int[n + 1];
        m = Integer.parseInt(st1.nextToken());
        for(int i = 0; i < m; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            graph.get(Integer.parseInt(st2.nextToken())).add(Integer.parseInt(st2.nextToken()));
        }

        check[1] = 1;
        T.dfs(1);
        System.out.println(answer);
    }
}
