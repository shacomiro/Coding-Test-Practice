import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution2828 {
    private int n;
    private int m;
    private int j;
    private int[] appleDrops;
    private int basketLeft;
    private int basketRignt;

    public Solution2828(int n, int m, int j, int[] appleDrops) {
        this.n = n;
        this.m = m;
        this.j = j;
        this.appleDrops = appleDrops;
        this.basketLeft = 1;
        this.basketRignt = m;
    }

    public String solve() {
        int move = 0;

        int i = 0;
        while(i < j) {
            if(basketLeft <= appleDrops[i] && appleDrops[i] <= basketRignt) {
                i++;
            } else {
                move++;

                if(basketRignt < appleDrops[i]) {
                    basketLeft++;
                    basketRignt++;
                } else {
                    basketLeft--;
                    basketRignt--;
                }
            }
            
        }

        return String.valueOf(move);
    }
}

public class Problem2828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int j = Integer.parseInt(br.readLine());
        int[] arr = new int[j];
        for(int i = 0; i < j; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        bw.write(new Solution2828(n, m, j, arr).solve());
        bw.flush();
        bw.close();
    }
}
