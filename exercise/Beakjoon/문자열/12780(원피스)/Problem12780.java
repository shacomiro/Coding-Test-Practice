import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem12780 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(new Solver(br.readLine(), br.readLine()).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private String h, n;

        public Solver(String h, String n) {
            this.h = h;
            this.n = n;
        }

        public String solve() {
            int count = 0;
            int fromIndex = 0;

            while ((fromIndex = h.indexOf(n, fromIndex)) != -1) {
                count++;
                fromIndex++;
            }

            return String.valueOf(count);
        }
    }
}
