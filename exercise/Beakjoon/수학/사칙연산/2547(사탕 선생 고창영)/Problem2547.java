import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class Problem2547 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            br.readLine();
            int n = Integer.parseInt(br.readLine());
            long[] arr = new long[n];
            for (int j = 0; j < n; j++) {
                arr[j] = Long.parseLong(br.readLine());
            }
            bw.write(new Solver(n, arr).solve());
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }

    static class Solver {
        private int n;
        private long[] candies;

        public Solver(int n, long[] candies) {
            this.n = n;
            this.candies = candies;
        }

        public String solve() {
            BigInteger sum = BigInteger.ZERO;
            for (int i = 0; i < n; i++) {
                sum = sum.add(BigInteger.valueOf(candies[i]));
            }

            return (sum.mod(BigInteger.valueOf(n)) == BigInteger.ZERO) ? "YES" : "NO";
        }
    }
}
