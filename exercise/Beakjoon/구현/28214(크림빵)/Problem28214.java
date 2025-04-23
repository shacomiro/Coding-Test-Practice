import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution28214 {
    private int n;
    private int k;
    private int p;
    private int[] breads;

    public Solution28214(int n, int k, int p, int[] breads) {
        this.n = n;
        this.k = k;
        this.p = p;
        this.breads = breads;
    }

    public String solve() {
        int cream = 0;
        int nonCream = 0;
        int sell = 0;

        for (int i = 0; i < n * k; i++) {
            if (breads[i] == 0) {
                nonCream++;
            } else {
                cream++;
            }

            if (cream + nonCream == k) {
                if (nonCream < p) {
                    sell++;
                }

                nonCream = 0;
                cream = 0;
            }
        }

        return String.valueOf(sell);
    }
}

public class Problem28214 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n * k];
        for (int i = 0; i < n * k; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(new Solution28214(n, k, p, arr).solve());
        bw.flush();
        bw.close();
    }
}
