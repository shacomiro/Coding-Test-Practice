import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem28014 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] h = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            h[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(new Solver(n, h).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private int n;
        private int[] h;

        public Solver(int n, int[] h) {
            this.n = n;
            this.h = h;
        }

        public String solve() {
            int count = 1;

            for (int i = 0; i < n - 1; i++) {
                if (h[i] <= h[i + 1]) {
                    count++;
                }
            }

            return String.valueOf(count);
        }
    }
}
