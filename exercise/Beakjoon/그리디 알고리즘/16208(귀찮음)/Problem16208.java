import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution16208 {
    private int[] bars;

    public Solution16208(int[] bars) {
        this.bars = bars;
    }

    public String solve() {
        long cost = 0;
        long sum = 0;

        Arrays.sort(bars);
        for(int i = 0; i < bars.length; i++) {
            sum += bars[i];
        }

        for(int i = 0; i < bars.length; i++) {
            sum -= bars[i];
            cost += bars[i] * sum;
        }

        return String.valueOf(cost);
    }
}

public class Problem16208 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(new Solution16208(arr).solve());
        bw.flush();
        bw.close();
    }
}
