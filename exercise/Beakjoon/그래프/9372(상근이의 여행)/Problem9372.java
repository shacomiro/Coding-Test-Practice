import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution9372 {
    private int n;
    private int m;
    private int[][] flights;

    public Solution9372(int n, int m, int[][] flights) {
        this.n = n;
        this.m = m;
        this.flights = flights;
    }

    public String solve() {
        return String.valueOf(n - 1);
    }
}

public class Problem9372 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[][] arr = new int[m][2];
            for(int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                arr[j][0] = Integer.parseInt(st.nextToken());
                arr[j][1] = Integer.parseInt(st.nextToken());
            }

            bw.write(new Solution9372(n, m, arr).solve());
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
