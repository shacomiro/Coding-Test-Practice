import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution10811 {
    private int n;
    private int m;
    private int[][] ranges;
    private int[] baskets;

    public Solution10811(int n, int m, int[][] ranges) {
        this.n = n;
        this.m = m;
        this.ranges = ranges;
        this.baskets = new int[n + 1];

        for(int i = 1; i <= n; i++) {
            baskets[i] = baskets[i - 1] + 1;
        }
    }

    public String solve() {
        for(int i = 0; i < m; i++) {
            swap(ranges[i][0], ranges[i][1]);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++) {
            sb.append(baskets[i]).append(" ");
        }

        return sb.toString();
    }

    private void swap(int from, int to) {
        while(from < to) {
            int temp = baskets[from];
            baskets[from] = baskets[to];
            baskets[to] = temp;

            from++;
            to--;
        }
    }
}

public class Problem10811 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[m][2];
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        bw.write(new Solution10811(n, m, arr).solve());
        bw.flush();
        bw.close();
    }
}
