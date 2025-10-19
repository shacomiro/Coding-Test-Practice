import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem5586 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(new Solver(br.readLine()).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private String str;

        public Solver(String str) {
            this.str = str;
        }

        public String solve() {
            int joiCnt = 0;
            int ioiCnt = 0;

            for (int i = 3; i <= str.length(); i++) {
                String sub = str.substring(i - 3, i);

                if (sub.equals("JOI")) {
                    joiCnt++;
                } else if (sub.equals("IOI")) {
                    ioiCnt++;
                }
            }

            return joiCnt + "\n" + ioiCnt;
        }
    }
}
