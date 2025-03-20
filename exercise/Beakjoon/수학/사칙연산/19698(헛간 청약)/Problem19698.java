import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution19698 {
    private int n;
    private int w;
    private int h;
    private int l;

    public Solution19698(int n, int w, int h, int l) {
        this.n = n;
        this.w = w;
        this.h = h;
        this.l = l;
    }

    public String solve() {
        int lw = w / l;
        int lh = h / l;
        int max = lw * lh;

        return String.valueOf((max < n) ? max : n);
    }
}

public class Problem19698 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        bw.write(new Solution19698(n, w, h, l).solve());
        bw.flush();
        bw.close();
    }
}
