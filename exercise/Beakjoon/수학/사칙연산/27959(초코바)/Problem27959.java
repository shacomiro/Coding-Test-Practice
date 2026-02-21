import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem27959 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        bw.write(new Solver(n, m).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private int n;
        private int m;

        public Solver(int n, int m) {
            this.n = n;
            this.m = m;
        }

        public String solve() {
            return (100 * n >= m) ? "Yes" : "No";
        }
    }
}
