import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.util.StringTokenizer;

public class Problem17356 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        bw.write(new Solver(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private int a;
        private int b;

        public Solver(int a, int b) {
            this.a = a;
            this.b = b;
        }

        public String solve() {
            return BigDecimal.valueOf(1 / (1 + Math.pow(10, (b - a) / 400.0))).toPlainString();
        }
    }
}
