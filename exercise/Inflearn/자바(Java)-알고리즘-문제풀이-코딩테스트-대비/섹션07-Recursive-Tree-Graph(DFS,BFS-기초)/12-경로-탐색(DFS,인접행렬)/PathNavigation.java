import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int answer = 0;
    static int n;
    static int m;
    static int[] check;
    static int[][] graph;

    public void dfs(int v) {
        if(v == n) answer++;
        else {
            for(int i = 1; i <= n; i++) {
                if(graph[v][i] == 1) {
                    if(check[i] == 0) {
                        check[i] = 1;
                        dfs(i);
                        check[i] = 0;
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
        graph = new int[n + 1][n + 1];
        check = new int[n + 1];
        m = Integer.parseInt(st1.nextToken());
        for(int i = 0; i < m; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            graph[Integer.parseInt(st2.nextToken())][Integer.parseInt(st2.nextToken())] = 1;
        }

        check[1] = 1;
        T.dfs(1);
        System.out.println(answer);
    }
}
