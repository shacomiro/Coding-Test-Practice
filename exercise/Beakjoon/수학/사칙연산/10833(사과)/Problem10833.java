import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem10833 {
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

        bw.write(new Solver(n, arr).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private int n;
        private int[][] schools;

        public Solver(int n, int[][] schools) {
            this.n = n;
            this.schools = schools;
        }

        public String solve() {
            int left = 0;

            for (int i = 0; i < n; i++) {
                while (schools[i][0] <= schools[i][1]) {
                    schools[i][1] -= schools[i][0];
                }
                left += schools[i][1];
            }

            return String.valueOf(left);
        }
    }
}
