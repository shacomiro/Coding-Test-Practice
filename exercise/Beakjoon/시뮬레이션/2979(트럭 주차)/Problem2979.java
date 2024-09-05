import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution2979 {
    private int[] cost;
    private int[][] parkingTimes;

    public Solution2979(int costA, int costB, int costC, int[][] parkingTimes) {
        this.cost = new int[] {0, costA, costB, costC};
        this.parkingTimes = parkingTimes;
    }

    public String solve() {
        int[] parked = new int[101];
        int totalCost = 0;

        for(int[] pt : parkingTimes) {
            int enter = pt[0];
            int leave = pt[1];

            for(int t = enter; t < leave; t++) {
                parked[t]++;
            }
        }

        for(int p : parked) {
            totalCost += p * cost[p];
        }

        return String.valueOf(totalCost);
    }
}

public class Problem2979 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[][] arr = new int[3][2];
        for(int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        bw.write(new Solution2979(a, b, c, arr).solve());
        bw.flush();
        bw.close();
    }
}
