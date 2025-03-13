import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution15565 {
    private int n;
    private int k;
    private int[] dolls;

    public Solution15565(int n, int k, int[] dolls) {
        this.n = n;
        this.k = k;
        this.dolls = dolls;
    }

    public String solve() {
        int min = Integer.MAX_VALUE;
        int count = 0;

        int lt = 0;
        for(int rt = 0; rt < n; rt++) {
            if(dolls[rt] == 1) {
                count++;
            }

            while(count >= k) {
                min = Math.min(min, rt - lt + 1);

                if(dolls[lt++] == 1) {
                    count--;
                }
            }
        }

        return String.valueOf((min == Integer.MAX_VALUE) ? -1 : min);
    }
}

public class Problem15565 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(new Solution15565(n, k, arr).solve());
        bw.flush();
        bw.close();
    }
}
