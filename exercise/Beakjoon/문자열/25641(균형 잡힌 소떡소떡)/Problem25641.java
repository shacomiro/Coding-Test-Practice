import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem25641 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(new Solver(Integer.parseInt(br.readLine()), br.readLine()).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private int n;
        private String s;

        public Solver(int n, String s) {
            this.n = n;
            this.s = s;
        }

        public String solve() {
            int sCnt = 0;
            int tCnt = 0;

            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == 's') {
                    sCnt++;
                } else {
                    tCnt++;
                }
            }

            for (int i = 0; i < n; i++) {
                if (sCnt == tCnt) {
                    s = s.substring(i, n);
                    break;
                }

                if (s.charAt(i) == 's') {
                    sCnt--;
                } else {
                    tCnt--;
                }
            }

            return s;
        }
    }
}
