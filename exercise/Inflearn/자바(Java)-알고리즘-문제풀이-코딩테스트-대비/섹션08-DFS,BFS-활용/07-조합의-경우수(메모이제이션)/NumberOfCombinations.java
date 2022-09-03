import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, r;
    static int[][] combi;

    public int dfs(int cn, int cr) {
        if(combi[cn][cr] > 0) return combi[cn][cr];
        if(cn < cr) return 0;
        if(cr == 1) {
            combi[cn][cr] = cn;
            return cn;
        } else {
            return dfs(cn - 1, cr - 1) + dfs(cn - 1, cr);
        }
    }

    int[][] dy;

    public int DFS(int n, int r) {
        if(dy[n][r] > 0) return dy[n][r];
        if(n == r || r == 0) return 1;
        else return dy[n][r] = DFS(n - 1, r - 1) + DFS(n - 1, r);
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st1.nextToken());
        r = Integer.parseInt(st1.nextToken());
        combi = new int[n + 1][r + 1];

        System.out.println(T.dfs(n, r));

    }
}
