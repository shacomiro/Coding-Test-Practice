import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution10158 {
    private int w;
    private int h;
    private int p;
    private int q;
    private int t;

    public Solution10158(int w, int h, int p, int q, int t) {
        this.w = w;
        this.h = h;
        this.p = p;
        this.q = q;
        this.t = t;
    }

    public String solve() {
        p = (p + t) % (2 * w);
        q = (q + t) % (2 * h);

        p = (p > w) ? (2 * w) - p : p;
        q = (q > h) ? (2 * h) - q : q;

        return p + " " + q;
    }
}

public class Problem10158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(br.readLine());

        bw.write(new Solution10158(w, h, p, q, t).solve());
        bw.flush();
        bw.close();
    }
}
