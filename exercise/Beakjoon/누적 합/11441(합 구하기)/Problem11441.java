import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution11441 {
    private int n;
    private int[] numbers;
    private int m;
    private int[][] betweens;
    private int[] dp;

    public Solution11441(int n, int[] numbers, int m, int[][] betweens) {
        this.n = n;
        this.numbers = numbers;
        this.m = m;
        this.betweens = betweens;
        this.dp = new int[n + 1];
    }

    public String solve() {
        int sum = 0;
        for(int i = 1; i <= n; i++) {
            sum += numbers[i - 1];
            dp[i] = sum;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < m; i++) {
            sb.append(dp[betweens[i][1]] - dp[betweens[i][0] - 1]).append("\n");
        }

        return sb.toString();
    }
}

public class Problem11441 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr1 = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());
        int[][] arr2 = new int[m][2];
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            arr2[i][0] = Integer.parseInt(st.nextToken());
            arr2[i][1] = Integer.parseInt(st.nextToken());
        }

        bw.write(new Solution11441(n, arr1, m, arr2).solve());
        bw.flush();
        bw.close();
    }
}