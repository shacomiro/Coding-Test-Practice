import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution11726 {
    private int[] dp;
    private int n;

    public Solution11726(int n) {
        this.dp = new int[n + 1];
        this.n = n;

        if(n >= 1) dp[1] = 1;
        if(n >= 2) dp[2] = 2;
    }

    public String solve() {
        for(int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
        }

        return String.valueOf(dp[n]);
    }
}

public class Problem11726 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        bw.write(new Solution11726(n).solve());
        bw.flush();
        bw.close();
    }
}