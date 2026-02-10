import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem26040 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(new Solver(br.readLine(), br.readLine()).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private String A;
        private String B;

        public Solver(String A, String B) {
            this.A = A;
            this.B = B;
        }

        public String solve() {
            for (char c : B.toCharArray()) {
                A = A.replaceAll(String.valueOf(c), String.valueOf(Character.toLowerCase(c)));
            }

            return A;
        }
    }
}
