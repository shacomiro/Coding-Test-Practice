import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Solution14501 {
    private int[] dp;
    private int days;
    private List<int[]> counslings;

    public Solution14501(int days, List<int[]> counslings) {
        this.dp = new int[counslings.size() + 1];
        this.days = days;
        this.counslings = counslings;
    }

    public String solve() {
        for(int day = 0; day < days; day++) {
            int duration = counslings.get(day)[0];
            int pay = counslings.get(day)[1];

            if(day + duration < dp.length) {
                dp[day + duration] = Math.max(dp[day + duration], dp[day] + pay);
            }
            
            dp[day + 1] = Math.max(dp[day + 1], dp[day]);
        }

        return String.valueOf(dp[days]);
    }
}

public class Problem14501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        List<int[]> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        bw.write(new Solution14501(n, list).solve());
        bw.flush();
        bw.close();
    }
}
