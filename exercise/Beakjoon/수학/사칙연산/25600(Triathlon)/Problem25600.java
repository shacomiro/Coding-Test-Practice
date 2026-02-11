import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem25600 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }

        bw.write(new Solver(n, arr).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private int n;
        private int[][] scores;

        public Solver(int n, int[][] scores) {
            this.n = n;
            this.scores = scores;
        }

        public String solve() {
            int maxScore = 0;

            for (int i = 0; i < n; i++) {
                int a = scores[i][0];
                int dg = scores[i][1] + scores[i][2];

                maxScore = Math.max(((a == dg) ? 2 : 1) * a * dg, maxScore);
            }

            return String.valueOf(maxScore);
        }
    }
}