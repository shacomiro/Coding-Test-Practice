import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution2467 {
    private int[] liquids;

    public Solution2467(int[] liquids) {
        this.liquids = liquids;
    }

    public String solve() {
        int lt = 0;
        int rt = liquids.length - 1;
        int min = Integer.MAX_VALUE;
        int lIdxA = -1;
        int lIdxB = -1;

        while(lt < rt) {
            int mix = liquids[lt] + liquids[rt];
            int absMix = Math.abs(mix);

            if(absMix < min) {
                min = absMix;
                lIdxA = lt;
                lIdxB = rt;
            }

            if(mix < 0) {
                lt++;
            } else {
                rt--;
            }
        }

        return String.valueOf(liquids[lIdxA] + " " + liquids[lIdxB]);
    }
}

public class Problem2467 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(new Solution2467(arr).solve());
        bw.flush();
        bw.close();
    }
}
