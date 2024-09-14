import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution1929 {
    private int m;
    private int n;
    private boolean[] isNotPrime;

    public Solution1929(int m, int n) {
        this.m = m;
        this.n = n;
        this.isNotPrime = new boolean[n + 1];
    }

    public String solve() {
        isNotPrime[1] = true;
        
        for(int i = 2; i <= n; i++) {
            if(!isNotPrime[i]) {
                for(int j = i + i; j <= n; j += i) {
                    isNotPrime[j] = true;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = m; i <= n; i++) {
            if(!isNotPrime[i]) {
                sb.append(i).append("\n");
            }
        }

        return sb.toString();
    }
}

public class Problem1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        bw.write(new Solution1929(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())).solve());
        bw.flush();
        bw.close();
    }
}
