import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static String[] answer;
    static int idx = 0;
    static int n, m;

    public void dfs(String set, int size) {
        if(size == m) {
            answer[idx++] = set;
        } else {
            for(int i = 0; i < n; i++) {
                dfs(set + (i + 1) + " ", size + 1);
            }
        }
    }

    static int[] pm;

    public void DFS(int L) {
        if(L == m) {
            for(int x : pm) System.out.print(x + " ");
            System.out.println();
        } else {
            for(int i = 1; i <= n; i++) {
                pm[L] = i;
                DFS(L + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st1.nextToken());
        m = Integer.parseInt(st1.nextToken());
        answer = new String[(int) Math.pow(n, m)];

        T.dfs("", 0);
        for(int i = 0; i < answer.length; i++) System.out.println(answer[i]);

        pm = new int[m];
        T.DFS(0);
    }
}
