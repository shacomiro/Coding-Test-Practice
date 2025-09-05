import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        BigInteger a = new BigInteger(st.nextToken());
        BigInteger b = new BigInteger(st.nextToken());

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
            return String.valueOf(a.add(b));
        }
    }
}
