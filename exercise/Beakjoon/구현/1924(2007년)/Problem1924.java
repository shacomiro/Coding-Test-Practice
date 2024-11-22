import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution1924 {
    private final int[] dayOfMonths = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private final String[] dayOfWeeks = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
    private int month;
    private int day;

    public Solution1924(int month, int day) {
        this.month = month;
        this.day = day;
    }

    public String solve() {
        int days = 0;

        for(int m = 1; m < month; m++) {
            days += dayOfMonths[m - 1];
        }
        days += day;

        return dayOfWeeks[days % 7];
    }
}

public class Problem1924 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        bw.write(new Solution1924(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())).solve());
        bw.flush();
        bw.close();
    }
}
