import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution9037 {
    private int n;
    private int[] candies;
    private int[] halfs;

    public Solution9037(int n, int[] candies) {
        this.n = n;
        this.candies = candies;
        this.halfs = new int[n];
    }

    public String solve() {
        int cycle = 0;
        addBonusCandies();

        while(!isAllSameCandies()) {
            passingCandies();
            addBonusCandies();

            cycle++;
        }

        return String.valueOf(cycle);
    }

    private void passingCandies() {
        for(int i = 0; i < n; i++) {
            halfs[i] = candies[i] / 2;
        }

        for(int i = 0; i < n; i++) {
            candies[i] -= halfs[i];
            candies[(i + 1) % n] += halfs[i];
        }
    }

    private void addBonusCandies() {
        for(int i = 0; i < n; i++) {
            if(candies[i] % 2 == 1) {
                candies[i]++;
            }
        }
    }

    private boolean isAllSameCandies() {
        if(n == 1) {
            return true;
        }

        for(int i = 0; i < n - 1; i++) {
            if(candies[i] != candies[i + 1]) {
                return false;
            }
        }

        return true;
    }
}

public class Problem9037 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            bw.write(new Solution9037(n, arr).solve());
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
