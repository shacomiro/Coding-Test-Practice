import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution1246 {
    private int n;
    private int m;
    private int[] budgets;

    public Solution1246(int n, int m, int[] budgets) {
        this.n = n;
        this.m = m;
        this.budgets = budgets;
    }

    public String solve() {
        Arrays.sort(budgets);

        int maxPrice = 0;
        int maxIncome = 0;
        for(int i = 0; i < m; i++) {
            int currIncome = budgets[i] * Math.min(n, m - i);

            if(maxIncome <= currIncome) {
                maxPrice = budgets[i];
                maxIncome = currIncome;
            }
        }

        return String.valueOf(maxPrice + " " + maxIncome);
    }
}

public class Problem1246 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[m];
        for(int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        bw.write(new Solution1246(n, m, arr).solve());
        bw.flush();
        bw.close();
    }
}
