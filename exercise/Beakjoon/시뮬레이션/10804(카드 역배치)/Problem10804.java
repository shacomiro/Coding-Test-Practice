import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution10804 {
    private int[][] intervals;
    private int[] cards;

    public Solution10804(int[][] intervals) {
        this.intervals = intervals;
        this.cards = new int[21];

        for(int i = 1; i <= 20; i++) {
            cards[i] = i;
        }
    }

    public String solve() {
        for(int[] interval : intervals) {
            int from = interval[0];
            int to = interval[1];

            while(from < to) {
                int temp = cards[from];
                cards[from] = cards[to];
                cards[to] = temp;

                from++;
                to--;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= 20; i++) {
            sb.append(cards[i]).append(" ");
        }

        return sb.toString();
    }
}

public class Problem10804 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int[][] arr = new int[10][2];
        for(int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        bw.write(new Solution10804(arr).solve());
        bw.flush();
        bw.close();
    }
}
