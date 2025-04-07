import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class Solution30088 {
    private int n;
    private List<List<Integer>> leaveTimes;
    private int[] dp;

    public Solution30088(int n, List<List<Integer>> leaveTimes) {
        this.n = n;
        this.leaveTimes = leaveTimes;
        this.dp = new int[n];
    }

    public String solve() {
        long[] departmentsSum = new long[n];
        for(int i = 0; i < n; i++) {
            for(int t : leaveTimes.get(i)) {
                departmentsSum[i] += t;
            }
        }
        Arrays.sort(departmentsSum);

        long totalTime = 0;
        for(int i = 0; i < n; i++) {
            dp[i] += (i > 0) ? departmentsSum[i] + dp[i - 1] : departmentsSum[i];
            totalTime += dp[i];
        }

        return String.valueOf(totalTime);
    }
}

public class Problem30088 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        List<List<Integer>> list = new ArrayList<>(n);
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            list.add(new ArrayList<>(m));
            for(int j = 0; j < m; j++) {
                list.get(i).add(Integer.parseInt(st.nextToken()));
            }
        }

        bw.write(new Solution30088(n, list).solve());
        bw.flush();
        bw.close();
    }
}
