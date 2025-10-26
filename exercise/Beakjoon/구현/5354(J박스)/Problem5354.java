import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem5354 {
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
        private int n;

        public Solver(int n) {
            this.n = n;
        }

        public String solve() {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    sb.append((i == 0 || j == 0 || i == n - 1 || j == n - 1) ? "#" : "J");
                }
                sb.append("\n");
            }

            return sb.toString();
        }
    }
}
