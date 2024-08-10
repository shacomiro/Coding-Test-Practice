import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution2869 {
    private int climb;
    private int slip;
    private int height;

    public Solution2869(int climb, int slip, int height) {
        this.climb = climb;
        this.slip = slip;
        this.height = height;
    }

    public String solve() {
        int climbPerDay = climb - slip;
        int minHeight = height - slip;
        int day = minHeight / climbPerDay;

        if(minHeight % climbPerDay != 0) {
            day++;
        }

        return String.valueOf(day);
    }
}

public class Problem2869 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        bw.write(new Solution2869(a, b, v).solve());
        bw.flush();
        bw.close();
    }
}
