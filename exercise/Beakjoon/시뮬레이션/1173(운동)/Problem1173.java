import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution1173 {
    private int n;
    private int min;
    private int max;
    private int train;
    private int rest;

    public Solution1173(int n, int min, int max, int train, int rest) {
        this.n = n;
        this.min = min;
        this.max = max;
        this.train = train;
        this.rest = rest;
    }

    public String solve() {
        if (min + train > max) {
            return "-1";
        }

        int totalTime = 0;
        int exercisedTime = 0;
        int currentPulse = min;

        while (exercisedTime < n) {
            if (currentPulse + train <= max) {
                currentPulse += train;
                exercisedTime++;
            } else {
                currentPulse = Math.max(min, currentPulse - rest);
            }

            totalTime++;
        }

        return String.valueOf(totalTime);
    }
}

public class Problem1173 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int min = Integer.parseInt(st.nextToken());
        int max = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        bw.write(new Solution1173(n, min, max, t, r).solve());
        bw.flush();
        bw.close();
    }
}
