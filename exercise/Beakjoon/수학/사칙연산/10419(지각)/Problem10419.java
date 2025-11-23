import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem10419 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            bw.write(new Solver(Integer.parseInt(br.readLine())).solve());
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    static class Solver {
        private int d;

        public Solver(int d) {
            this.d = d;
        }

        public String solve() {
            int t = 0;
            int max = 0;

            while (d - (t * t) - t >= 0) {
                max = t;
                t++;
            }

            return String.valueOf(max);
        }
    }
}
