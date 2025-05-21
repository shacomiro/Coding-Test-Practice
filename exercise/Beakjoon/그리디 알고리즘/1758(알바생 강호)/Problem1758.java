import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

class Solution1758 {
    private int n;
    private int[] tips;

    public Solution1758(int n, int[] tips) {
        this.n = n;
        this.tips = tips;
    }

    public String solve() {
        Arrays.sort(tips);

        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Math.max(tips[n - i - 1] - i, 0);
        }

        return String.valueOf(sum);
    }
}

public class Problem1758 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        bw.write(new Solution1758(n, arr).solve());
        bw.flush();
        bw.close();
    }
}
