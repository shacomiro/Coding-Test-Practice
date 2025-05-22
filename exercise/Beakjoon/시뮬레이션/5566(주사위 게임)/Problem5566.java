import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution5566 {
    private int n;
    private int m;
    private int[] board;
    private int[] dice;

    public Solution5566(int n, int m, int[] board, int[] dice) {
        this.n = n;
        this.m = m;
        this.board = board;
        this.dice = dice;
    }

    public String solve() {
        int now = 0;
        int i = 0;

        while (now < n - 1) {
            now += dice[i++];

            if (now < n - 1) {
                now += board[now];
            }
        }

        return String.valueOf(i);
    }
}

public class Problem5566 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr1 = new int[n];
        int[] arr2 = new int[m];
        for (int i = 0; i < n; i++) {
            arr1[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 0; i < m; i++) {
            arr2[i] = Integer.parseInt(br.readLine());
        }

        bw.write(new Solution5566(n, m, arr1, arr2).solve());
        bw.flush();
        bw.close();
    }
}
