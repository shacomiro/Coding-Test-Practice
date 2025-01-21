import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution2303 {
    private int n;
    private int[][] cards;

    public Solution2303(int n, int[][] cards) {
        this.n = n;
        this.cards = cards;
    }

    public String solve() {
        int max = 0;
        int id = -1;

        for(int i = 0; i < n; i++) {
            int pMax = getMax(cards[i]);
            if(pMax >= max) {
                max = pMax;
                id = i + 1;
            }
        }

        return String.valueOf(id);
    }

    private int getMax(int[] personalCards) {
        int max = 0;

        for(int i = 0; i < 5; i++) {
            for(int j = i + 1; j < 5; j++) {
                for(int k = j + 1; k < 5; k++) {
                    max = Math.max(max, (personalCards[i] + personalCards[j] + personalCards[k]) % 10);
                }
            }
        }

        return max;
    }
}

public class Problem2303 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][5];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bw.write(new Solution2303(n, arr).solve());
        bw.flush();
        bw.close();
    }
}
