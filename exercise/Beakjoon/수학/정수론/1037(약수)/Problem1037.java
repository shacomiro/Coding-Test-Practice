import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution1037 {
    private int[] divisor;

    public Solution1037(int[] divisor) {
        this.divisor = divisor;
    }

    public String solve() {
        int min = 1000000;
        int max = 1;

        for(int d : divisor) {
            min = Math.min(min, d);
            max = Math.max(max, d);
        }

        return String.valueOf(min * max);
    }
}

public class Problem1037 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(new Solution1037(arr).solve());
        bw.flush();
        bw.close();
    }
}
