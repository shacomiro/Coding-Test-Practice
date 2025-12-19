import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem14470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        int d = Integer.parseInt(br.readLine());
        int e = Integer.parseInt(br.readLine());

        bw.write(new Solver(a, b, c, d, e).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private int a, b, c, d, e;

        public Solver(int a, int b, int c, int d, int e) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
            this.e = e;
        }

        public String solve() {
            int t = 0;

            if (a < 0) {
                t += Math.abs(a) * c;
                a = 0;
            }

            if (a == 0) {
                t += d;
            }

            t += (b - a) * e;

            return String.valueOf(t);
        }
    }
}
