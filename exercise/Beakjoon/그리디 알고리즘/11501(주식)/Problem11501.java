import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution11501 {
    private int[] stocks;

    public Solution11501(int[] stocks) {
        this.stocks = stocks;
    }

    public String solve() {
        long profit = 0;
        int sell = 0;

        for(int i = stocks.length - 1; i >= 0; i--) {
            if(sell > stocks[i]) {
                profit += sell - stocks[i];
            } else {
                sell = stocks[i];
            }
        }

        return String.valueOf(profit);
    }
}

public class Problem11501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[n];
            for(int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            bw.write(new Solution11501(arr).solve());
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
