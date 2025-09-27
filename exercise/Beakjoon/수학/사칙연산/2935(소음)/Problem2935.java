import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

class Problem2935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        BigInteger a = new BigInteger(br.readLine());
        char op = br.readLine().charAt(0);
        BigInteger b = new BigInteger(br.readLine());

        bw.write(new Solver(a, op, b).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private BigInteger a;
        private char operator;
        private BigInteger b;

        public Solver(BigInteger a, char operator, BigInteger b) {
            this.a = a;
            this.operator = operator;
            this.b = b;
        }

        public String solve() {
            BigInteger result = BigInteger.ZERO;

            switch (operator) {
                case '+':
                    result = a.add(b);
                    break;
                case '*':
                    result = a.multiply(b);
                    break;
            }

            return result.toString();
        }
    }
}