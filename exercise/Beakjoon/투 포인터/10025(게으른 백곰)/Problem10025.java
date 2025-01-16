import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution10025 {
    private int n;
    private int k;
    private int[] cage;

    public Solution10025(int n, int k, int[] cage) {
        this.n = n;
        this.k = k;
        this.cage = cage;
    }

    public String solve() {
        int lt = 0;
        int rt = 0;
        int sum = 0;
        int max = 0;

        while(rt < cage.length) {
            sum += cage[rt];
            max = Math.max(sum, max);

            if(lt == rt - 2 * k) {
                sum -= cage[lt];
                lt++;
            }
            rt++;
        }

        return String.valueOf(max);
    }
}

public class Problem10025 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[1000001];       
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int g = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            arr[x] = g;
        }

        bw.write(new Solution10025(n, k, arr).solve());
        bw.flush();
        bw.close();
    }
}
