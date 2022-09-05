import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] combi;

    public void dfs(int L, int s) {
        if(L == m) {
            for(int x : combi) System.out.print(x + " ");
            System.out.println();
        } else {
            for(int i = s; i <= n; i++) {
                combi[L] = i;
                dfs(L + 1, i + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st1.nextToken());
        m = Integer.parseInt(st1.nextToken());
        combi = new int[m];

        T.dfs(0, 1);
    }
}
