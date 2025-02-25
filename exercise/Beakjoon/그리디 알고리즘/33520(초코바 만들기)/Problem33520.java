import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution33520 {
    private int n;
    private int[][] chocoBars;

    public Solution33520(int n, int[][] chocoBars) {
        this.n = n;
        this.chocoBars = chocoBars;
    }

    public String solve() {
        int sMax = 0;
        int lMax = 0;

        for(int[] chocoBar : chocoBars) {
            int l = Math.max(chocoBar[0], chocoBar[1]);
            int s = Math.min(chocoBar[0], chocoBar[1]);

            sMax = Math.max(sMax, s);
            lMax = Math.max(lMax, l);
        }

        return String.valueOf((long) sMax * lMax);
    }
}

public class Problem33520 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        bw.write(new Solution33520(n, arr).solve());
        bw.flush();
        bw.close();
    }
}
