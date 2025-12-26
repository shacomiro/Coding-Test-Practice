import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem15734 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int l = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());

        bw.write(new Solver(l, r, a).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private int l, r, a;

        public Solver(int l, int r, int a) {
            this.l = l;
            this.r = r;
            this.a = a;
        }

        public String solve() {
            int diff = Math.abs(l - r);
            int max = Math.max(l, r);

            if (a <= diff) {
                if (l < r) {
                    l += a;
                } else {
                    r += a;
                }
            } else {
                l = max + (a - diff) / 2;
                r = max + (a - diff) / 2;
            }

            return String.valueOf(Math.min(l, r) * 2);
        }
    }
}
