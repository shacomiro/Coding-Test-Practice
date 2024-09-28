import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution2720 {
    private final int[] qdnp = {25, 10, 5, 1};
    private int[] count;
    private int change;

    public Solution2720(int change) {
        this.change = change;
        this.count = new int[4];
    }

    public String solve() {
        int idx = 0;

        while(change > 0) {
            count[idx] = change / qdnp[idx];
            change = change % qdnp[idx];
            idx++;
        }

        return String.valueOf(count[0] + " " + count[1] + " " + count[2] + " " + count[3]);
    }
}

public class Problem2720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            bw.write(new Solution2720(Integer.parseInt(br.readLine())).solve());
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
