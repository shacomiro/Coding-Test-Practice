import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem5612 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        bw.write(new Solver(n, m, arr).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private int n;
        private int m;
        private int[][] counts;

        public Solver(int n, int m, int[][] counts) {
            this.n = n;
            this.m = m;
            this.counts = counts;
        }

        public String solve() {
            int remain = m;
            int max = m;

            for (int i = 0; i < n; i++) {
                remain += counts[i][0] - counts[i][1];

                if (remain < 0) {
                    return "0";
                }

                max = Math.max(remain, max);
            }

            return String.valueOf(max);
        }
    }
}
