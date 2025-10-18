import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Problem5565 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int p = Integer.parseInt(br.readLine());
        int[] arr = new int[9];
        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        bw.write(new Solver(p, arr).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private int totalPrice;
        private int[] prices;

        public Solver(int totalPrice, int[] prices) {
            this.totalPrice = totalPrice;
            this.prices = prices;
        }

        public String solve() {
            return String.valueOf(totalPrice - Arrays.stream(prices).sum());
        }
    }
}
