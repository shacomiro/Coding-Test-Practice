import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem31668 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        bw.write(new Solver(n, m, k).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private int n;
        private int m;
        private int k;

        public Solver(int n, int m, int k) {
            this.n = n;
            this.m = m;
            this.k = k;
        }

        public String solve() {
            return String.valueOf(m / n * k);
        }
    }
}
