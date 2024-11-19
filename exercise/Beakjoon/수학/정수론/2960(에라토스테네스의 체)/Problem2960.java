import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution2960 {
    private int n;
    private int k;

    public Solution2960(int n, int k) {
        this.n = n;
        this.k = k;
    }

    public String solve() {
        return String.valueOf(sieveOfEratosthenes());
    }
    
    private int sieveOfEratosthenes() {
        boolean[] isNotPrime = new boolean[n + 1];

        for(int p = 2; p <= n; p++) {
            if(!isNotPrime[p]) {
                k--;

                if(k == 0) {
                    return p;
                }

                for(int np = p * 2; np <= n; np += p) {
                    if(!isNotPrime[np]) {
                        isNotPrime[np] = true;
                        k--;

                        if(k == 0) {
                            return np;
                        }
                    }
                }
            }
        }

        return -1;
    }
}

public class Problem2960 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        bw.write(new Solution2960(n, k).solve());
        bw.flush();
        bw.close();
    }
}