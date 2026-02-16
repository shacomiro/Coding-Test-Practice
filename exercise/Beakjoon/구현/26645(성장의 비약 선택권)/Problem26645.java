import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem26645 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(new Solver(Integer.parseInt(br.readLine())).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private int n;

        public Solver(int n) {
            this.n = n;
        }

        public String solve() {
            if (200 <= n && n <= 205) {
                return "1";
            } else if (206 <= n && n <= 217) {
                return "2";
            } else if (218 <= n && n <= 228) {
                return "3";
            }

            return "4";
        }
    }
}
