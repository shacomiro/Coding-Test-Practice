import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem10156 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        bw.write(new Solver(k, n, m).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private int k;
        private int n;
        private int m;

        public Solver(int k, int n, int m) {
            this.k = k;
            this.n = n;
            this.m = m;
        }

        public String solve() {
            return String.valueOf(((k * n) < m) ? 0 : (k * n) - m);
        }
    }
}