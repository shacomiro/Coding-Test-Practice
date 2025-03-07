import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution20546 {
    private int seed;
    private int[] stockPrices;

    public Solution20546(int seed, int[] stockPrices) {
        this.seed = seed;
        this.stockPrices = stockPrices;
    }

    public String solve() {
        int bnpSeed = seed;
        int timingSeed = seed;
        int bnpStock = 0;
        int timingStock = 0;
        int up = 0;
        int down = 0;

        for(int i = 0; i < 14; i++) {
            bnpStock += bnpSeed / stockPrices[i];
            bnpSeed %= stockPrices[i];

            if(i >= 1) {
                if(stockPrices[i] > stockPrices[i - 1]) {
                    up += 1;
                    down = 0;
                } else if(stockPrices[i] < stockPrices[i - 1]) {
                    down += 1;
                    up = 0;
                }
            }

            if(up >= 3 && timingStock > 0) {
                timingSeed += timingStock * stockPrices[i];
                timingStock = 0;
            }
            if(down >= 3 && timingSeed / stockPrices[i] > 0) {
                timingStock += timingSeed / stockPrices[i];
                timingSeed %= stockPrices[i];
            }
        }

        int bnpAssets = bnpSeed + (bnpStock * stockPrices[13]);
        int timingAssets = timingSeed + (timingStock * stockPrices[13]);

        return String.valueOf((bnpAssets == timingAssets) ? "SAMESAME" : ((bnpAssets > timingAssets) ? "BNP" : "TIMING"));
    }
}

public class Problem20546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int s = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[14];
        for(int i = 0; i < 14; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(new Solution20546(s, arr).solve());
        bw.flush();
        bw.close();
    }
}
