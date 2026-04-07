import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem32154 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(new Solver(Integer.parseInt(br.readLine())).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private static boolean[][] SCORE_BOARD = new boolean[][] {
                { true, true, true, true, true, true, true, true, false, true, false, true, true },
                { true, false, true, false, true, true, true, true, true, false, false, true, true },
                { true, false, true, false, true, true, true, true, true, false, false, true, true },
                { true, true, true, false, true, true, true, true, false, false, false, true, true },
                { true, false, true, false, true, true, true, true, false, false, false, true, true },
                { true, false, true, false, true, true, true, true, false, false, false, true, true },
                { true, false, true, false, true, true, true, true, false, false, false, true, true },
                { true, false, true, false, true, true, true, true, false, false, false, true, true },
                { true, false, true, false, true, true, true, true, false, false, false, true, true },
                { true, true, true, false, false, true, true, true, false, false, false, true, true },
        };
        private int n;

        public Solver(int n) {
            this.n = n;
        }

        public String solve() {
            StringBuilder sb = new StringBuilder();
            int count = 0;

            for (int i = 0; i < 13; i++) {
                if (SCORE_BOARD[n - 1][i]) {
                    count++;
                    sb.append((char) ('A' + i)).append(" ");
                }
            }
            sb.insert(0, count + "\n");

            return sb.toString();
        }
    }
}
