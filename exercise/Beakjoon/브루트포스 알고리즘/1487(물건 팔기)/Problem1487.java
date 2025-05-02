import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution1487 {
    private int n;
    private int[][] pay;

    public Solution1487(int n, int[][] pay) {
        this.n = n;
        this.pay = pay;
    }

    public String solve() {
        int bestPrice = 0;
        int bestProfit = 0;

        for (int i = 0; i < n; i++) {
            int price = pay[i][0];
            int profit = 0;

            for (int j = 0; j < n; j++) {
                int income = price - pay[j][1];

                if (income > 0 && pay[j][0] >= price) {
                    profit += income;
                }
            }

            if (profit > bestProfit || (profit == bestProfit && price < bestPrice)) {
                bestPrice = price;
                bestProfit = profit;
            }
        }

        return String.valueOf(bestPrice);
    }
}

public class Problem1487 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        bw.write(new Solution1487(n, arr).solve());
        bw.flush();
        bw.close();
    }
}
