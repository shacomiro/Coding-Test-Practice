import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution2775 {
    private int k;
    private int n;
    private int[][] dp;

    public Solution2775(int k, int n) {
        this.n = n;
        this.k = k;
        this.dp = new int[k + 1][n + 1];
    }

    public String solve() {
        for(int i = 1; i <= n; i++) {
            dp[0][i] = i;
        }

        for(int floor = 1; floor <= k; floor++) {
            int sum = 0;

            for(int room = 1; room <= n; room++) {
                sum += dp[floor - 1][room];
                dp[floor][room] = sum;
            }
        }

        return String.valueOf(dp[k][n]);
    }
}

public class Problem2775 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            bw.write(new Solution2775(Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine())).solve());
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
