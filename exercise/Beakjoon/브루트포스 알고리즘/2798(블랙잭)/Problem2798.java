import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution2798 {
    private int goal;
    private int[] cards;

    public Solution2798(int goal, int[] cards) {
        this.goal = goal;
        this.cards = cards;
    }

    public String solve() {
        int max = 0;

        for(int i = 0; i < cards.length; i++) {
            if(cards[i] >= goal) {
                continue;
            }

            for(int j = i + 1; j < cards.length; j++) {
                if(cards[j] >= goal) {
                    continue;
                }

                for(int k = j + 1; k < cards.length; k++) {
                    if(cards[k] >= goal) {
                        continue;
                    }

                    int sum = cards[i] + cards[j] + cards[k];

                    if(sum == goal) {
                        return String.valueOf(sum);
                    }
                    max = sum <= goal && max < sum ? sum : max;
                }
            }
        }

        return String.valueOf(max);
    }
}

public class Problem2798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(new Solution2798(m, arr).solve());
        bw.flush();
        bw.close();
    }
}
