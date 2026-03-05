import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Map;

public class Problem29725 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[][] arr = new char[8][8];
        for (int i = 0; i < 8; i++) {
            String input = br.readLine();
            for (int j = 0; j < 8; j++) {
                arr[i][j] = input.charAt(j);
            }
        }

        bw.write(new Solver(arr).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private static final Map<Character, Integer> PEICE_POINTS = Map.of('K', 0, 'P', 1, 'N', 3, 'B', 3, 'R', 5, 'Q',
                9);
        private char[][] chessBoard;

        public Solver(char[][] chessBoard) {
            this.chessBoard = chessBoard;
        }

        public String solve() {
            int point = 0;

            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    char piece = chessBoard[i][j];

                    if (piece == '.') {
                        continue;
                    }

                    point += PEICE_POINTS.get(Character.toUpperCase(piece)) * (Character.isUpperCase(piece) ? 1 : -1);
                }
            }

            return String.valueOf(point);
        }
    }
}
