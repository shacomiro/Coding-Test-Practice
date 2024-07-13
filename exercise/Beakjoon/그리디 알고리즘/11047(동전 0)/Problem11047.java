import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution11047 {
    private int[] coins;
    private int sum;

    public Solution11047(int[] coins, int sum) {
        this.coins = coins;
        this.sum = sum;
    }

    public String solve() {
        int count = 0;

        for(int i = coins.length - 1; i >= 0; i--) {
            count += sum / coins[i];
            sum = sum % coins[i];
        }

        return String.valueOf(count);
    }
}

public class Problem11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        bw.write(new Solution11047(arr, k).solve());
        bw.flush();
        bw.close();
    }
}
