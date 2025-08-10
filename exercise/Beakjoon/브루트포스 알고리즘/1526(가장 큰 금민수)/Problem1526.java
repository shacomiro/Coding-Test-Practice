import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem1526 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        bw.write(new Solver(n).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private int n;
        private int maxGeumMinSoo;

        public Solver(int n) {
            this.n = n;
        }

        public String solve() {
            find(4);
            find(7);

            return String.valueOf(maxGeumMinSoo);
        }

        private void find(long current) {
            if (current > n) {
                return;
            }

            maxGeumMinSoo = Math.max(maxGeumMinSoo, (int) current);
            find(current * 10 + 4);
            find(current * 10 + 7);
        }
    }
}
