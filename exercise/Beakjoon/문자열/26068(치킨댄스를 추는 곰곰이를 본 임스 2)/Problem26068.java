import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem26068 {
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
        private String[] x;

        public Solver(int n, String[] x) {
            this.n = n;
            this.x = x;
        }

        public String solve() {
            int count = 0;

            for (int i = 0; i < n; i++) {
                if (Integer.parseInt(x[i].split("-")[1]) <= 90) {
                    count++;
                }
            }

            return String.valueOf(count);
        }
    }
}
