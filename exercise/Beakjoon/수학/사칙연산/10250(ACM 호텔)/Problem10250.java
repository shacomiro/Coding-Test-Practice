import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution10250 {
    private int height;
    private int width;
    private int n;

    public Solution10250(int height, int width, int n) {
        this.height = height;
        this.width = width;
        this.n = n;
    }

    public String solve() {
        int y = (n - 1) % height + 1;
        int x = (n - 1) / height + 1;

        return String.format("%d%02d", y, x);
    }
}

public class Problem10250 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            bw.write(new Solution10250(h, w, n).solve());
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
