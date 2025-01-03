import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution2399 {
    private int n;
    private int[] coordinates;

    public Solution2399(int n, int[] coordinates) {
        this.n = n;
        this.coordinates = coordinates;
    }

    public String solve() {
        long totalDistance = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                totalDistance += Math.abs(coordinates[i] - coordinates[j]);
            }
        }

        return String.valueOf(totalDistance);
    }
}

public class Problem2399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(new Solution2399(n, arr).solve());
        bw.flush();
        bw.close();
    }
}
