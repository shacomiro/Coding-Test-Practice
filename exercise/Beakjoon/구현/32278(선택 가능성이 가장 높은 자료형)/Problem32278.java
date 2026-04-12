import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem32278 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(new Solver(Long.parseLong(br.readLine())).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private long n;

        public Solver(long n) {
            this.n = n;
        }

        public String solve() {
            if (Short.MIN_VALUE <= n && n <= Short.MAX_VALUE) {
                return "short";
            } else if (Integer.MIN_VALUE <= n && n <= Integer.MAX_VALUE) {
                return "int";
            } else {
                return "long long";
            }
        }
    }
}
