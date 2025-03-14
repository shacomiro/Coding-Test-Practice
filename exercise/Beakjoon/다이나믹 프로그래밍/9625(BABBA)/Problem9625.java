import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution9625 {
    private int k;
    private int[][] dp;

    public Solution9625(int k) {
        this.k = k;
        this.dp = new int[k + 1][2];
    }

    public String solve() {
        dp[0][0] = 1;
        dp[0][1] = 0;

        for(int i = 1; i <= k; i++) {
            dp[i][0] = dp[i - 1][1];
            dp[i][1] = dp[i - 1][0] + dp[i - 1][1];
        }

        return String.valueOf(dp[k][0] + " " + dp[k][1]);
    }
}

public class Problem9625 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(new Solution9625(Integer.parseInt(br.readLine())).solve());
        bw.flush();
        bw.close();
    }
}
