import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution2167 {
    private int[][] array;
    private int[][] range;
    private int[][] sum;

    public Solution2167(int height, int width, int[][] array, int[][] range) {
        this.array = array;
        this.range = range;
        this.sum = new int[height + 1][width + 1];
    }

    public String solve() {
        for(int i = 1; i < sum.length; i++) {
            for(int j = 1; j < sum[i].length; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + array[i - 1][j - 1];
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int[] r : range) {
            int i = r[0];
            int j = r[1];
            int x = r[2];
            int y = r[3];

            sb.append(sum[x][y] - sum[i - 1][y] - sum[x][j - 1] + sum[i - 1][j - 1]).append("\n");
        }

        return sb.toString();
    }
}

public class Problem2167 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr1 = new int[n][m];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                arr1[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int k = Integer.parseInt(br.readLine());
        int[][] arr2 = new int[k][4];
        for(int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            arr2[i][0] = Integer.parseInt(st.nextToken());
            arr2[i][1] = Integer.parseInt(st.nextToken());
            arr2[i][2] = Integer.parseInt(st.nextToken());
            arr2[i][3] = Integer.parseInt(st.nextToken());
        }

        bw.write(new Solution2167(n, m, arr1, arr2).solve());
        bw.flush();
        bw.close();
    }
}
