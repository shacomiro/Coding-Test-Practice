import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution2566 {
    private int[][] grid;
    private int max;
    private int[] maxPosition;

    public Solution2566(int[][] grid) {
        this.grid = grid;
        this.max = -1;
        this.maxPosition = new int[] {-1, -1};
    }

    public String solve() {
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(max < grid[i][j]) {
                    max = grid[i][j];
                    maxPosition[0] = i + 1;
                    maxPosition[1] = j + 1;
                }
            }
        }

        return String.valueOf(max + "\n" + maxPosition[0] + " " + maxPosition[1]);
    }
}

public class Problem2566 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int[][] arr = new int[9][9];
        for(int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 9; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bw.write(new Solution2566(arr).solve());
        bw.flush();
        bw.close();
    }
}
