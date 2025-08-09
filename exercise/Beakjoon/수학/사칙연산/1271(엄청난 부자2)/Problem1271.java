import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Problem1271 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        BigInteger n = new BigInteger(st.nextToken());
        BigInteger m = new BigInteger(st.nextToken());

        bw.write(new Solver(n, m).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private BigInteger n;
        private BigInteger m;

        public Solver(BigInteger n, BigInteger m) {
            this.n = n;
            this.m = m;
        }

        public String solve() {
            BigInteger[] result = n.divideAndRemainder(m);

            return result[0] + "\n" + result[1];
        }
    }
}
