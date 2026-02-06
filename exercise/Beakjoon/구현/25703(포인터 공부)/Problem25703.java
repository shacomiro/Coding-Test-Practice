import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem25703 {
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
            StringBuilder sb = new StringBuilder("int a;\nint *ptr = &a;\n");

            int curr = 1;
            int next = 2;
            for (int i = 1; i < n; i++) {
                sb.append("int ").append("*".repeat(next)).append("ptr")
                        .append(next).append(" = &ptr").append((curr != 1 ? curr : ""))
                        .append(";\n");
                curr++;
                next++;
            }

            return sb.toString();
        }
    }
}
