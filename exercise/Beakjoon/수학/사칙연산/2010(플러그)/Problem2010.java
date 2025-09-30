import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem2010 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        bw.write(new Solver(n, arr).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private int n;
        private int[] plugs;

        public Solver(int n, int[] plugs) {
            this.n = n;
            this.plugs = plugs;
        }

        public String solve() {
            int count = 0;

            for (int i = 0; i < n - 1; i++) {
                count += plugs[i] - 1;
            }
            count += plugs[n - 1];

            return String.valueOf(count);
        }
    }
}
