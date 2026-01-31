import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem25704 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int p = Integer.parseInt(br.readLine());

        bw.write(new Solver(n, p).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private int n, p;

        public Solver(int n, int p) {
            this.n = n;
            this.p = p;
        }

        public String solve() {
            int minPrice = p;

            if (n >= 20) {
                minPrice = Math.min(minPrice, p - (p / 4));
            }
            if (n >= 15) {
                minPrice = Math.min(minPrice, p - (2000));
            }
            if (n >= 10) {
                minPrice = Math.min(minPrice, p - (p / 10));
            }
            if (n >= 5) {
                minPrice = Math.min(minPrice, p - (500));
            }

            return String.valueOf(Math.max(minPrice, 0));
        }
    }
}
