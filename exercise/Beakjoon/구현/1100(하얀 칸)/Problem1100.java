import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution1100 {
    private char[][] board;

    public Solution1100(char[][] board) {
        this.board = board;
    }

    public String solve() {
        int count = 0;

        for(int x = 0; x < 8; x++) {
            for(int y = 0; y < 8; y++) {
                if((x + y) % 2 == 0 && board[x][y] == 'F') {
                    count++;
                }
            }
        }

        return String.valueOf(count);
    }
}

public class Problem1100 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input;

        char[][] arr = new char[8][8];
        for(int i = 0; i < 8; i++) {
            input = br.readLine();
            for(int j = 0; j < 8; j++) {
                arr[i][j] = input.charAt(j);
            }
        }

        bw.write(new Solution1100(arr).solve());
        bw.flush();
        bw.close();
    }
}
