import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class Problem2338 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        BigInteger a = new BigInteger(br.readLine());
        BigInteger b = new BigInteger(br.readLine());

        bw.write(new Solver(a, b).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private BigInteger a;
        private BigInteger b;

        public Solver(BigInteger a, BigInteger b) {
            this.a = a;
            this.b = b;
        }

        public String solve() {
            return (a.add(b)) + "\n" + (a.subtract(b)) + "\n" + (a.multiply(b));
        }
    }
}
