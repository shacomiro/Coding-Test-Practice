import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem31821 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr1 = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = Integer.parseInt(br.readLine());
        }
        int m = Integer.parseInt(br.readLine());
        int[] arr2 = new int[m];
        for (int i = 0; i < m; i++) {
            arr2[i] = Integer.parseInt(br.readLine());
        }

        bw.write(new Solver(n, arr1, m, arr2).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private int n;
        private int m;
        private int[] prices;
        private int[] orders;

        public Solver(int n, int[] prices, int m, int[] orders) {
            this.n = n;
            this.m = m;
            this.prices = prices;
            this.orders = orders;
        }

        public String solve() {
            int sum = 0;

            for (int i = 0; i < m; i++) {
                sum += prices[orders[i] - 1];
            }

            return String.valueOf(sum);
        }
    }
}
