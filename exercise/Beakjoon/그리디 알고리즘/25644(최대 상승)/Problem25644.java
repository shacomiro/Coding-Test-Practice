import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution25644 {
    private int n;
    private int[] prices;

    public Solution25644(int n, int[] prices) {
        this.n = n;
        this.prices = prices;
    }

    public String solve() {
        int buy = Integer.MAX_VALUE;
        int sell = Integer.MIN_VALUE;
        int income = 0;

        for(int i = 0; i < n; i++) {
            if(buy >= prices[i]) {
                buy = prices[i];
                sell = prices[i];
            } else if(sell <= prices[i]) {
                sell = prices[i];
                income = Math.max(income, sell - buy);
            }
        }

        return String.valueOf(income);
    }
}

public class Problem25644 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(new Solution25644(n, arr).solve());
        bw.flush();
        bw.close();
    }
}
