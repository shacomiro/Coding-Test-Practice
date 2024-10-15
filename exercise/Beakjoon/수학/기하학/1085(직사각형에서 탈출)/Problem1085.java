import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution1085 {
    private int x;
    private int y;
    private int width;
    private int height;

    public Solution1085(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public String solve() {
        int minH = Math.min(Math.abs(0 - x), width - x);
        int minV = Math.min(Math.abs(0 - y), height - y);

        return String.valueOf(Math.min(minH, minV));
    }
}

public class Problem1085 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        bw.write(new Solution1085(x, y, w, h).solve());
        bw.flush();
        bw.close();
    }
}
