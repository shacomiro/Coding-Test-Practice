import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem31867 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String k = br.readLine();

        bw.write(new Solver(n, k).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private int n;
        private String k;

        public Solver(int n, String k) {
            this.n = n;
            this.k = k;
        }

        public String solve() {
            int odd = 0;
            int even = 0;

            for (int i = 0; i < n; i++) {
                if (Character.getNumericValue(k.charAt(i)) % 2 == 0) {
                    even++;
                } else {
                    odd++;
                }
            }

            return (odd == even) ? "-1" : (odd > even) ? "1" : "0";
        }
    }
}
