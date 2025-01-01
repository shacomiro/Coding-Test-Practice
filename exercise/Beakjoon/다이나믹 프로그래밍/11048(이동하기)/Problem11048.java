import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution11048 {
    private int n;
    private int m;
    private int[][] maze;
    private int[][] dp;

    public Solution11048(int n, int m, int[][] maze) {
        this.n = n;
        this.m = m;
        this.maze = maze;
        this.dp = new int[n + 1][m + 1];
    }

    public String solve() {
        for(int x = 1; x <= n; x++) {
            for(int y = 1; y <= m; y++) {
                dp[x][y] = maze[x - 1][y - 1] + Math.max(dp[x - 1][y - 1], Math.max(dp[x - 1][y], dp[x][y - 1]));
            }
        }

        return String.valueOf(dp[n][m]);
    }
}

public class Problem11048 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bw.write(new Solution11048(n, m, arr).solve());
        bw.flush();
        bw.close();
    }
}
