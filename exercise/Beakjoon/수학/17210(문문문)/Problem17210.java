import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem17210 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long n = Long.parseLong(br.readLine());
        int o = Integer.parseInt(br.readLine());

        bw.write(new Solver(n, o).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private long n;
        private int open;

        public Solver(long n, int open) {
            this.n = n;
            this.open = open;
        }

        public String solve() {
            if (n >= 6) {
                return "Love is open door";
            }

            StringBuilder sb = new StringBuilder();

            for (int i = 2; i <= n; i++) {
                open = 1 - open;
                sb.append(open).append("\n");
            }

            return sb.toString();
        }
    }
}
