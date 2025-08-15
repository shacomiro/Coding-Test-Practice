import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem1681 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        bw.write(new Solver(n, l).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private int n;
        private int l;

        public Solver(int n, int l) {
            this.n = n;
            this.l = l;
        }

        public String solve() {
            int count = 0;
            int label = 0;

            while (count < n) {
                label++;

                if (isValidLabel(label)) {
                    count++;
                }
            }

            return String.valueOf(label);
        }

        private boolean isValidLabel(int label) {
            while (label > 0) {
                if (label % 10 == l) {
                    return false;
                }

                label /= 10;
            }

            return true;
        }
    }
}
