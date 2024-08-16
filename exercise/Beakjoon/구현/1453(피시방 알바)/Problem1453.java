import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Solution1453 {
    private boolean[] seat;
    private List<Integer> requests;

    public Solution1453(List<Integer> requests) {
        this.seat = new boolean[101];
        this.requests = requests;
    }

    public String solve() {
        int count = 0;

        for(int req : requests) {
            if(!seat[req]) {
                seat[req] = true;
            } else {
                count++;
            }
        }

        return String.valueOf(count);
    }
}

public class Problem1453 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>(n);
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        bw.write(new Solution1453(list).solve());
        bw.flush();
        bw.close();
    }
}
