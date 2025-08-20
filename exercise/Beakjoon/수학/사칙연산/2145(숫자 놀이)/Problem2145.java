import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem2145 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input;

        while (!(input = br.readLine()).equals("0")) {
            bw.write(new Solver(Integer.parseInt(input)).solve());
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
            int sum = 0;

            while (n >= 10) {
                while (n > 0) {
                    sum += n % 10;
                    n /= 10;
                }

                n = sum;
                sum = 0;
            }

            return String.valueOf(n);
        }
    }
}
