import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem33990 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bw.write(new Solver(n, arr).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private int n;
        private int[][] bsds;

        public Solver(int n, int[][] bsds) {
            this.n = n;
            this.bsds = bsds;
        }

        public String solve() {
            int closestWeight = Integer.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                int bsd = Arrays.stream(bsds[i]).sum();

                if (bsd >= 512 && bsd < closestWeight) {
                    closestWeight = bsd;
                }
            }

            return String.valueOf((closestWeight == Integer.MAX_VALUE) ? "-1" : closestWeight);
        }
    }
}
