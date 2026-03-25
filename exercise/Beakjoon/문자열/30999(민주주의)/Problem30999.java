import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem30999 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String[] s = new String[n];
        for (int i = 0; i < n; i++) {
            s[i] = br.readLine();
        }

        bw.write(new Solver(n, m, s).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private int n;
        private int m;
        private String[] s;

        public Solver(int n, int m, String[] s) {
            this.n = n;
            this.m = m;
            this.s = s;
        }

        public String solve() {
            int count = 0;
            int agree = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (s[i].charAt(j) == 'O') {
                        agree++;
                    }
                }

                if (agree >= (double) m / 2) {
                    count++;
                }
                agree = 0;
            }

            return String.valueOf(count);
        }
    }
}
