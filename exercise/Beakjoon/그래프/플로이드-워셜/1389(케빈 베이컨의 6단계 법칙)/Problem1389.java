import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution1389 {
    private int n;
    private int m;
    private int[][] graph;

    public Solution1389(int n, int m, int[][] graph) {
        this.n = n;
        this.m = m;
        this.graph = graph;
    }

    public String solve() {
        int minKBNumber = Integer.MAX_VALUE;
        int minId = -1;

        floydWarshall();

        for(int id = 1; id <= n; id++) {
            int kbNumber = 0;

            for(int step : graph[id]) {
                kbNumber += step;
            }

            if(kbNumber < minKBNumber) {
                minKBNumber = kbNumber;
                minId = id;
            }
        }

        return String.valueOf(minId);
    }

    private void floydWarshall() {
        for(int k = 1; k <= n; k++) {
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= n; j++) {
                    if(i == j || j == k || k == i) {
                        continue;
                    }

                    if(graph[i][j] > graph[i][k] + graph[k][j]) {
                        graph[i][j] = graph[i][k] + graph[k][j];
                    }
                }
            }
        }
    }
}

public class Problem1389 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n + 1][n + 1];
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                arr[i][j] = (i == j) ? 0 : 5000;
            }
        }
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a][b] = 1;
            arr[b][a] = 1;
        }

        bw.write(new Solution1389(n, m, arr).solve());
        bw.flush();
        bw.close();
    }
}
