import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

class Solution13706 {
    private BigInteger n;

    public Solution13706(BigInteger n) {
        this.n = n;
    }

    public String solve() {
        return String.valueOf(sqrt(n));
    }

    private BigInteger sqrt(BigInteger x) {
        BigInteger left = BigInteger.ZERO;
        BigInteger right = x;
        BigInteger mid, squre;

        while (left.compareTo(right) <= 0) {
            mid = left.add(right).divide(BigInteger.TWO);
            squre = mid.multiply(mid);

            int comparison = squre.compareTo(x);

            if (comparison == 0) {
                return mid;
            } else if (comparison < 0) {
                left = mid.add(BigInteger.ONE);
            } else {
                right = mid.subtract(BigInteger.ONE);
            }
        }

        return right;
    }
}

public class Problem13706 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(new Solution13706(new BigInteger(br.readLine())).solve());
        bw.flush();
        bw.close();
    }
}
