import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution10810 {
    private int[] buckets;
    private int[][] balls;

    public Solution10810(int size, int[][] balls) {
        this.buckets = new int[size];
        this.balls = balls;
    }

    public String solve() {
        for(int[] ball : balls) {
            for(int i = ball[0] - 1; i <= ball[1] - 1; i++) {
                buckets[i] = ball[2];
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int b : buckets) {
            sb.append(b).append(" ");
        }

        return sb.toString();
    }
}

public class Problem10810 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[m][3];
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }

        bw.write(new Solution10810(n, arr).solve());
        bw.flush();
        bw.close();
    }
}
