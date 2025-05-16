import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution10801 {
    private int[][] cards;

    public Solution10801(int[][] cards) {
        this.cards = cards;
    }

    public String solve() {
        int aScore = 0;
        int bScore = 0;

        for (int i = 0; i < 10; i++) {
            if (cards[0][i] > cards[1][i]) {
                aScore++;
            } else if (cards[0][i] < cards[1][i]) {
                bScore++;
            }
        }

        return (aScore == bScore) ? "D" : ((aScore > bScore) ? "A" : "B");
    }
}

public class Problem10801 {
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

        bw.write(new Solution10801(arr).solve());
        bw.flush();
        bw.close();
    }
}
