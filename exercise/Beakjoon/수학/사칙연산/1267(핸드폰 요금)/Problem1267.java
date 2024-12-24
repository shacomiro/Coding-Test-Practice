import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution1267 {
    private final int Y_TIME = 30;
    private final int Y_COST = 10;
    private final int M_TIME = 60;
    private final int M_COST = 15;
    private int n;
    private int[] calls;

    public Solution1267(int n, int[] calls) {
        this.n = n;
        this.calls = calls;
    }

    public String solve() {
        int ySum = 0;
        int mSum = 0;

        for(int call : calls) {
            ySum += (call / Y_TIME + 1) * Y_COST;
            mSum += (call / M_TIME + 1) * M_COST;
        }

        return (ySum == mSum) ? "Y M " + ySum : (ySum < mSum) ? "Y " + ySum : "M " + mSum;
    }
}

public class Problem1267 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(new Solution1267(n, arr).solve());
        bw.flush();
        bw.close();
    }
}
