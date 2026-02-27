import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem28701 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(new Solver(Integer.parseInt(br.readLine())).solve());
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
            int sum = 0;
            int lhs = 0;
            int rhs = 0;

            for (int i = 1; i <= n; i++) {
                sum += i;
                rhs += Math.pow(i, 3);
            }
            lhs += Math.pow(sum, 2);

            sb.append(sum).append("\n")
                    .append(lhs).append("\n")
                    .append(rhs);

            return sb.toString();
        }
    }
}