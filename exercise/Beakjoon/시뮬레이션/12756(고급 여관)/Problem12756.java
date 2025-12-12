import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem12756 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int[][] arr = new int[2][2];
        for (int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
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
            while (cards[0][1] > 0 && cards[1][1] > 0) {
                cards[0][1] -= cards[1][0];
                cards[1][1] -= cards[0][0];
            }

            return (cards[0][1] <= 0 && cards[1][1] <= 0) ? "DRAW"
                    : ((cards[0][1] > 0) ? "PLAYER A" : "PLAYER B");
        }
    }
}
