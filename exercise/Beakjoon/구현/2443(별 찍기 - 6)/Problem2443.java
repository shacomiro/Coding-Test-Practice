import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
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
            
            for (int i = n; i >= 1; i--) {
                for (int j = 0; j < n - i; j++) {
                    sb.append(" ");
                }
                for (int j = 0; j < 2 * i - 1; j++) {
                    sb.append("*");
                }
                sb.append("\n");
            }

            return sb.toString();
        }
    }
}
