import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution1297 {
    private int diagonal;
    private int heightRatio;
    private int widthRatio;

    public Solution1297(int diagonal, int heightRatio, int widthRatio) {
        this.diagonal = diagonal;
        this.heightRatio = heightRatio;
        this.widthRatio = widthRatio;
    }

    public String solve() {
        double scaleFactor = diagonal / Math.sqrt(Math.pow(heightRatio, 2) + Math.pow(widthRatio, 2));

        int height = (int) Math.floor(heightRatio * scaleFactor);
        int width = (int) Math.floor(widthRatio * scaleFactor);

        return height + " " + width;
    }
}

public class Problem1297 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int d = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        bw.write(new Solution1297(d, h, w).solve());
        bw.flush();
        bw.close();
    }
}
