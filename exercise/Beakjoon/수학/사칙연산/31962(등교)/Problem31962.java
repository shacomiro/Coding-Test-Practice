import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution31962 {
    private int n;
    private int x;
    private int[][] buses;

    public Solution31962(int n, int x, int[][] buses) {
        this.n = n;
        this.x = x;
        this.buses = buses;
    }

    public String solve() {
        int latestStartTime = -1;

        for(int[] bus : buses) {
            int s = bus[0];
            int t = bus[1];

            if(s + t <= x) {
                latestStartTime = Math.max(latestStartTime, s);
            }
        }

        return String.valueOf(latestStartTime);
    }
}

public class Problem31962 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][2];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        bw.write(new Solution31962(n, x, arr).solve());
        bw.flush();
        bw.close();
    }
}
