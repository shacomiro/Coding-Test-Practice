import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem13235 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(new Solver(br.readLine()).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private String s;

        public Solver(String s) {
            this.s = s;
        }

        public String solve() {
            int lt = 0;
            int rt = s.length() - 1;

            while (lt < rt) {
                if (s.charAt(lt) != s.charAt(rt)) {
                    return "false";
                }

                lt++;
                rt--;
            }

            return "true";
        }
    }
}
