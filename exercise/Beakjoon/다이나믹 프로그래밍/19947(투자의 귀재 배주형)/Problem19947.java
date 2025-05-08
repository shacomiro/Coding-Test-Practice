import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution19947 {
    private int h;
    private int y;
    private int[] dp;

    public Solution19947(int h, int y) {
        this.h = h;
        this.y = y;
        this.dp = new int[y + 1];
    }

    public String solve() {
        dp[0] = h;

        for (int i = 0; i <= y; i++) {
            if (i + 1 <= y) {
                dp[i + 1] = Math.max(dp[i + 1], (int) (dp[i] * 1.05));
            }
            if (i + 3 <= y) {
                dp[i + 3] = Math.max(dp[i + 3], (int) (dp[i] * 1.20));
            }
            if (i + 5 <= y) {
                dp[i + 5] = Math.max(dp[i + 5], (int) (dp[i] * 1.35));
            }
        }

        return String.valueOf(dp[y]);
    }
}

public class Problem19947 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        bw.write(new Solution19947(h, y).solve());
        bw.flush();
        bw.close();
    }
}
