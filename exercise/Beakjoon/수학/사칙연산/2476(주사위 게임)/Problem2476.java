import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution2476 {
    private int n;
    private int[][] dices;

    public Solution2476(int n, int[][] dices) {
        this.n = n;
        this.dices = dices;
    }

    public String solve() {
        int max = 0;

        for(int i = 0; i < n; i++) {
            int d1 = dices[i][0];
            int d2 = dices[i][1];
            int d3 = dices[i][2];

            if(d1 == d2 && d2 == d3) {
                max = Math.max(max, 10000 + d2 * 1000);
            } else if(d1 == d2) {
                max = Math.max(max, 1000 + d1 * 100);
            } else if(d2 == d3) {
                max = Math.max(max, 1000 + d2 * 100);
            } else if(d3 == d1) {
                max = Math.max(max, 1000 + d3 * 100);
            } else {
                max = Math.max(max, Math.max(d1, Math.max(d2, d3)) * 100);
            }
        }

        return String.valueOf(max);
    }
}

public class Problem2476 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][3];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }

        bw.write(new Solution2476(n, arr).solve());
        bw.flush();
        bw.close();
    }
}
