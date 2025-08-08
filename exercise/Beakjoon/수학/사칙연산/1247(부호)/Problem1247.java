import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class Problem1247 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int t = 0; t < 3; t++) {
            int n = Integer.parseInt(br.readLine());
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Long.parseLong(br.readLine());
            }
            bw.write(new Solver(n, arr).solve());
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    static class Solver {
        private int n;
        private long[] numbers;

        public Solver(int n, long[] numbers) {
            this.n = n;
            this.numbers = numbers;
        }

        public String solve() {
            BigInteger sum = BigInteger.ZERO;
            
            for (int i = 0; i < n; i++) {
                sum = sum.add(BigInteger.valueOf(numbers[i]));
            }

            int sign = sum.signum();


            return (sign == 0) ? "0" : ((sign < 0) ? "-" : "+");
        }
    }
}
