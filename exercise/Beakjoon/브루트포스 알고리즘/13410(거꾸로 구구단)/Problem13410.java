import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem13410 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        bw.write(new Solver(n, k).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private int n, k;

        public Solver(int n, int k) {
            this.n = n;
            this.k = k;
        }

        public String solve() {
            int max = 0;

            for (int i = 1; i <= k; i++) {
                max = Math.max(Integer.parseInt(new StringBuilder().append(n * i).reverse().toString()), max);
            }

            return String.valueOf(max);
        }
    }
}
