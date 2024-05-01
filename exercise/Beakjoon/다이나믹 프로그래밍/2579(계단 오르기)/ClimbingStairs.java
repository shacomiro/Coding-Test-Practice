import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ClimbingStairs {
    public static int solution(int n, int[] stairs) {
        int[] dp = new int[n + 1];

        dp[1] = stairs[0];
        if(n >= 2) {
            dp[2] = stairs[0] + stairs[1];
        }

        for(int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 2], dp[i - 3] + stairs[i - 2]) + stairs[i - 1];
        }

        return dp[n];
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] stairs = new int[n];
        for(int i = 0; i < n; i ++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        bw.write(String.valueOf(solution(n, stairs)));
        bw.flush();
        bw.close();
    }
}
