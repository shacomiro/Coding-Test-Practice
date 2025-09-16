import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem3062 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            bw.write(new Solver(br.readLine()).solve());
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    static class Solver {
        private String n;

        public Solver(String n) {
            this.n = n;
        }

        public String solve() {
            int sum = Integer.parseInt(n) + Integer.parseInt(new StringBuilder(n).reverse().toString());

            return (sum == Integer.parseInt(new StringBuilder(String.valueOf(sum)).reverse().toString())) ? "YES"
                    : "NO";
        }
    }
}
