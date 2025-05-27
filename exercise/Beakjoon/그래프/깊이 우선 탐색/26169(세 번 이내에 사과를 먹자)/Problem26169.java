import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution26169 {
    private final int[] DX = { -1, 0, 1, 0 };
    private final int[] DY = { 0, 1, 0, -1 };
    private int[][] board;
    private int r;
    private int c;
    private boolean foundTwoApple;

    public Solution26169(int[][] board, int r, int c) {
        this.board = board;
        this.r = r;
        this.c = c;
        this.foundTwoApple = false;
    }

    public String solve() {
        dfs(r, c, 0, 0);

        return foundTwoApple ? "1" : "0";
    }

    private void dfs(int x, int y, int distance, int count) {
        if (foundTwoApple) {
            return;
        }

        int info = board[x][y];
        if (info == 1) {
            count++;
        }
        if (count >= 2) {
            foundTwoApple = true;
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + DX[i];
            int ny = y + DY[i];

            if (!(0 <= nx && nx < 5 && 0 <= ny && ny < 5)) {
                continue;
            }
            if (board[nx][ny] == -1) {
                continue;
            }
            if (distance + 1 > 3) {
                continue;
            }

            board[x][y] = -1;
            dfs(nx, ny, distance + 1, count);
            board[x][y] = info;
        }

    }
}

public class Problem26169 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int[][] arr = new int[5][5];
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        bw.write(new Solution26169(arr, r, c).solve());
        bw.flush();
        bw.close();
    }
}
