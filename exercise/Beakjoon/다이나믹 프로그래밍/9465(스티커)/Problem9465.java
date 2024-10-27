import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution9465 {
    private int size;
    private int[][] stikers;
    private int[][] dp;

    public Solution9465(int size, int[][] stikers) {
        this.size = size;
        this.stikers = stikers;
        this.dp = new int[2][size];
    }

    public String solve() {
        for(int i = 0; i < size; i++) {
            dp[0][i] = getMaxPoint(0, i);
            dp[1][i] = getMaxPoint(1, i);
        }

        return String.valueOf(Math.max(dp[0][size - 1], dp[1][size - 1]));
    }

    private int getMaxPoint(int x, int y) {
        return stikers[x][y] + Math.max((y >= 2) ? dp[1 - x][y - 2] : 0, (y >= 1) ? dp[1 - x][y - 1] : 0);
    }
}

public class Problem9465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[2][n];
            for(int j = 0; j < 2; j++) {
                st = new StringTokenizer(br.readLine());
                for(int k = 0; k < n; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            bw.write(new Solution9465(n, arr).solve());
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
