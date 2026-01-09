import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem16462 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        bw.write(new Solver(n, arr).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private int n;
        private int[] q;

        public Solver(int n, int[] q) {
            this.n = n;
            this.q = q;
        }

        public String solve() {
            int sum = 0;

            for (int i = 0; i < n; i++) {
                int digit = 1;
                int score = 0;

                while (q[i] > 0) {
                    int number = q[i] % 10;
                    score += ((number == 0 || number == 6 || number == 9) ? 9 : number) * digit;
                    q[i] /= 10;
                    digit *= 10;
                }

                sum += Math.min(score, 100);
            }

            return String.valueOf(Math.round((double) sum / n));
        }
    }
}
