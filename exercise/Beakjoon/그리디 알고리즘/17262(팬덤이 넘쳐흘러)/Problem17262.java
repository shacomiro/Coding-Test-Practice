import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution17262 {
    private int n;
    private int[][] fans;

    public Solution17262(int n, int[][] fans) {
        this.n = n;
        this.fans = fans;
    }

    public String solve() {
        int from = 0;
        int to = 100001;

        for (int i = 0; i < n; i++) {
            from = Math.max(from, fans[i][0]);
            to = Math.min(to, fans[i][1]);
        }
        int time = from - to;

        return String.valueOf((time > 0) ? time : 0);
    }
}

public class Problem17262 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        bw.write(new Solution17262(n, arr).solve());
        bw.flush();
        bw.close();
    }
}
