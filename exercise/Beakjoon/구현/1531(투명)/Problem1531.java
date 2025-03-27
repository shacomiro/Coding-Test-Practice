import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution1531 {
    private int n;
    private int m;
    private int[][] papers;
    private int[][] painting;

    public Solution1531(int n, int m, int[][] papers) {
        this.n = n;
        this.m = m;
        this.papers = papers;
        this.painting = new int[101][101];
    }

    public String solve() {
        for(int i = 0; i < n; i++) {
            for(int x = papers[i][0]; x <= papers[i][2]; x++) {
                for(int y = papers[i][1]; y <= papers[i][3]; y++) {
                    painting[x][y]++;
                }
            }
        }

        int count = 0;
        for(int x = 1; x <= 100; x++) {
            for(int y = 1; y <= 100; y++) {
                if(painting[x][y] > m) {
                    count++;
                }
            }
        }

        return String.valueOf(count);
    }
}

public class Problem1531 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][4];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 4; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bw.write(new Solution1531(n, m, arr).solve());
        bw.flush();
        bw.close();
    }
}
