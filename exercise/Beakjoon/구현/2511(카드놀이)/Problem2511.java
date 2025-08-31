import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem2511 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int[][] arr = new int[2][10];
        for (int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bw.write(new Solver(arr).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private int[][] cards;

        public Solver(int[][] cards) {
            this.cards = cards;
        }

        public String solve() {
            char currentWinner = 'X';
            int aSocre = 0;
            int bScore = 0;

            for (int round = 0; round < 10; round++) {
                if (cards[0][round] > cards[1][round]) {
                    currentWinner = 'A';
                    aSocre += 3;
                } else if (cards[0][round] < cards[1][round]) {
                    currentWinner = 'B';
                    bScore += 3;
                } else {
                    aSocre += 1;
                    bScore += 1;
                }
            }

            return aSocre + " " + bScore + "\n"
                    + (aSocre > bScore ? "A" : (aSocre < bScore ? "B" : (currentWinner == 'X' ? "D" : currentWinner)));
        }
    }
}
