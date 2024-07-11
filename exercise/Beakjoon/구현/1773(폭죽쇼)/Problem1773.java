import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Solution1773 {
    private boolean[] timeTable;
    private List<Integer> durations;

    public Solution1773(int time, List<Integer> durations) {
        this.timeTable = new boolean[time + 1];
        this.durations = durations;
    }

    public String solve() {
        int count = 0;

        for(int d : durations) {
            for(int i = d; i < timeTable.length; i += d) {
                if(timeTable[i]) {
                    continue;
                }

                timeTable[i] = true;
                count++;
            }
        }

        return String.valueOf(count);
    }
}

public class Problem1773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        List<Integer> list = new ArrayList<>(n);
        for(int i = 0; i < n; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        bw.write(new Solution1773(c, list).solve());
        bw.flush();
        bw.close();
    }
}
