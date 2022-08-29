import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int answer = 0;

    public void dfs(int L, int sum, int time, int[][] arr) {
        if(time > m) return;
        if(L == n) {
            answer = Math.max(answer , sum);
        } else {
            dfs(L + 1, sum + arr[L][0], time + arr[L][1], arr);
            dfs(L + 1, sum, time, arr);
        }
    }

    public void DFS(int L, int sum, int time, int[] ps, int[] pt) {
        if(time > m) return;
        if(L == n) {
            answer = Math.max(answer ,sum);
        } else {
            DFS(L + 1, sum + ps[L], time + pt[L], ps, pt);
            DFS(L + 1, sum, time, ps, pt);
        }
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st1.nextToken());
        m = Integer.parseInt(st1.nextToken());
        int[][] arr = new int[n][2];
        int[] a = new int[n];
        int[] b = new int[n];
        for(int i = 0; i < n; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int score = Integer.parseInt(st2.nextToken());
            int time = Integer.parseInt(st2.nextToken());
            arr[i][0] = score;
            arr[i][1] = time;
            a[i] = score;
            b[i] = time;
        }

        T.dfs(0, 0, 0, arr);
        T.DFS(0, 0, 0, a, b);
        System.out.println(answer);
    }
}
