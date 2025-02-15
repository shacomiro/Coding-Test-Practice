import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution14430 {
    private int n;
    private int m;
    private int[][] map;
    private int[][] dp;

    public Solution14430(int n, int m, int[][] map) {
        this.n = n;
        this.m = m;
        this.map = map;
        this.dp = new int[n][m];
    }

    public String solve() {
        dp[0][0] = map[0][0];

        for(int x = 1; x < n; x++) {
            dp[x][0] = dp[x - 1][0] + map[x][0];
        }
        for(int y = 1; y < m; y++) {
            dp[0][y] = dp[0][y - 1] + map[0][y];
        }
        for(int x = 1; x < n; x++) {
            for(int y = 1; y < m; y++) {
                dp[x][y] = Math.max(dp[x - 1][y], dp[x][y - 1]) + map[x][y];
            }
        }

        return String.valueOf(dp[n - 1][m - 1]);
    }
}

public class Problem14430 {
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

        bw.write(new Solution14430(n, m, arr).solve());
        bw.flush();
        bw.close();
    }
}
