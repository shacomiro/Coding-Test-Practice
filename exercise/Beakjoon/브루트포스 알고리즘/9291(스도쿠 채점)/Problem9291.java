import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution9291 {
    private int t;
    private int[][] sudoku;

    public Solution9291(int t, int[][] sudoku) {
        this.t = t;
        this.sudoku = sudoku;
    }

    public String solve() {
        boolean[][] rowCheck = new boolean[9][10];
        boolean[][] colCheck = new boolean[9][10];
        boolean[][] boxCheck = new boolean[9][10];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int num = sudoku[i][j];

                if (rowCheck[i][num]) {
                    return "Case " + t + ": INCORRECT";
                }
                rowCheck[i][num] = true;

                if (colCheck[j][num]) {
                    return "Case " + t + ": INCORRECT";
                }
                colCheck[j][num] = true;

                int boxIdx = (i / 3) * 3 + (j / 3);
                if (boxCheck[boxIdx][num]) {
                    return "Case " + t + ": INCORRECT";
                }
                boxCheck[boxIdx][num] = true;
            }
        }

        return "Case " + t + ": CORRECT";
    }
}

public class Problem9291 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int i = 1; i <= t; i++) {
            int[][] arr = new int[9][9];
            for (int j = 0; j < 9; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < 9; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }

                if (i < t && j == 8) {
                    br.readLine();
                }
            }
            bw.write(new Solution9291(i, arr).solve());
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
