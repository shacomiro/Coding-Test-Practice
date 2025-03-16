import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution12847 {
    private int n;
    private int m;
    private int[] dailyWages;
    private long[] dp;

    public Solution12847(int n, int m, int[] dailyWages) {
        this.n = n;
        this.m = m;
        this.dailyWages = dailyWages;
        this.dp = new long[n + 1];
    }

    public String solve() {
        long sum = 0;
        for(int i = 0; i <= n; i++) {
            dp[i] += sum;

            if(i < n) {
                sum += dailyWages[i];
            }
        }

        long maxWage = 0;
        for(int i = m; i <= n; i++) {
            maxWage = Math.max(maxWage, dp[i] - dp[i - m]);
        }

        return String.valueOf(maxWage);
    }
}

public class Problem12847 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(new Solution12847(n, m, arr).solve());
        bw.flush();
        bw.close();
    }
}
