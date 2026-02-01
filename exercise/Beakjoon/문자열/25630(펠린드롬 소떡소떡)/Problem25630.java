import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem25630 {
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
            int lt = 0;
            int rt = n - 1;
            int magicCnt = 0;

            while (lt < rt) {
                if (s.charAt(lt) != s.charAt(rt)) {
                    magicCnt++;
                }

                lt++;
                rt--;
            }

            return String.valueOf(magicCnt);
        }
    }
}
