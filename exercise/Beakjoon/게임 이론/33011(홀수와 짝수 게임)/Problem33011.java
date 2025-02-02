import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution33011 {
    private int n;
    private int[] cards;

    public Solution33011(int n, int[] cards) {
        this.n = n;
        this.cards = cards;
    }

    public String solve() {
        int oddCnt = 0;
        int evenCnt = 0;

        for(int card : cards) {
            if(card % 2 == 1) {
                oddCnt++;
            } else {
                evenCnt++;
            }   
        }

        if(oddCnt == evenCnt) {
            return "heeda0528";
        }

        int cnt = (oddCnt > evenCnt) ? oddCnt : evenCnt;

        return (cnt % 2 == 1) ? "amsminn" : "heeda0528";
    }
}

public class Problem33011 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[n];
            for(int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            bw.write(new Solution33011(n, arr).solve());
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
