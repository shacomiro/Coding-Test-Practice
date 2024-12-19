import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution2003 {
    private int n;
    private int m;
    private int[] a;

    public Solution2003(int n, int m, int[] a) {
        this.n = n;
        this.m = m;
        this.a = a;
    }

    public String solve() {
        int count = 0;
        int sum = 0;
        int lt = 0;
        int rt = 0;

        while(true) {
            if(rt < n && sum < m) {
                sum += a[rt++];
            } else if(lt < n && sum >= m) {
                sum -= a[lt++];
            } else {
                break;
            }

            if(sum == m) {
                count++;
            }
        }

        return String.valueOf(count);
    }
}

public class Problem2003 {
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

        bw.write(new Solution2003(n, m, arr).solve());
        bw.flush();
        bw.close();
    }
}
