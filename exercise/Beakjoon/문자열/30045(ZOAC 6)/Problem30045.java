import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem30045 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        bw.write(new Solver(n, arr).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private int n;
        private String[] s;

        public Solver(int n, String[] s) {
            this.n = n;
            this.s = s;
        }

        public String solve() {
            int count = 0;

            for (int i = 0; i < n; i++) {
                if (s[i].contains("01") || s[i].contains("OI")) {
                    count++;
                }
            }

            return String.valueOf(count);
        }
    }
}
