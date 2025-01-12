import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution5063 {
    private int r;
    private int e;
    private int c;

    public Solution5063(int r, int e, int c) {
        this.r = r;
        this.e = e;
        this.c = c;
    }

    public String solve() {
        return (r == e - c) ? "does not matter" : (r < e - c) ? "advertise" : "do not advertise";
    }
}

public class Problem5063 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            bw.write(new Solution5063(r, e, c).solve());
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
