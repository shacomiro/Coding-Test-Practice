import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution10709 {
    private int h;
    private int w;
    private char[][] sky;

    public Solution10709(int h, int w, char[][] sky) {
        this.h = h;
        this.w = w;
        this.sky = sky;
    }

    public String solve() {
        StringBuilder sb = new StringBuilder();

        for(int x = 0; x < h; x++) {
            int cloudTime = -1;

            for(int y = 0; y < w; y++) {
                cloudTime = (sky[x][y] == 'c') ? 0 : 
                            (cloudTime >= 0) ? cloudTime + 1 : -1;
                
                sb.append(cloudTime).append(" ");
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}

public class Problem10709 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        char[][] arr = new char[h][w];
        for(int i = 0; i < h; i++) {
            char[] chars = br.readLine().toCharArray();
            for(int j = 0; j < w; j++) {
                arr[i][j] = chars[j];
            }
        }

        bw.write(new Solution10709(h, w, arr).solve());
        bw.flush();
        bw.close();
    }
}
