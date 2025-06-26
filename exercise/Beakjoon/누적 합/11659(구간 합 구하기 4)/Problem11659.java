import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution11659 {
    private int n;
    private int m;
    private int[] numbers;
    private int[][] intervals;
    private int[] dp;

    public Solution11659(int n, int m, int[] numbers, int[][] intervals) {
        this.n = n;
        this.m = m;
        this.numbers = numbers;
        this.intervals = intervals;
        this.dp = new int[n + 1];
    }

    // 5 4 3 2 1
    // 2~4
    // 0 5 9 12 14 15
    // 14-5=9

    public String solve() {
        for (int i = 1; i <= n; i++) {
            dp[i] += dp[i - 1] + numbers[i - 1];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            sb.append(dp[intervals[i][1]] - dp[intervals[i][0] - 1]).append("\n");
        }

        return sb.toString();
    }
}

public class Problem11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr1 = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        int[][] arr2 = new int[m][2];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            arr2[i][0] = Integer.parseInt(st.nextToken());
            arr2[i][1] = Integer.parseInt(st.nextToken());
        }

        bw.write(new Solution11659(n, m, arr1, arr2).solve());
        bw.flush();
        bw.close();
    }
}
