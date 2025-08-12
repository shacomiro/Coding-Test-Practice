import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem1524 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            br.readLine();
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[] arr1 = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr1[j] = Integer.parseInt(st.nextToken());
            }
            int[] arr2 = new int[m];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr2[j] = Integer.parseInt(st.nextToken());
            }
            bw.write(new Solver(n, m, arr1, arr2).solve());
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    static class Solver {
        private int n;
        private int m;
        private int[] s;
        private int[] b;

        public Solver(int n, int m, int[] s, int[] b) {
            this.n = n;
            this.m = m;
            this.s = s;
            this.b = b;
        }

        public String solve() {
            Arrays.sort(s);
            Arrays.sort(b);

            int sIdx = 0;
            int bIdx = 0;

            while (sIdx < n && bIdx < m) {
                if (s[sIdx] < b[bIdx]) {
                    sIdx++;
                } else {
                    bIdx++;
                }
            }

            return (bIdx == m) ? "S" : "B";
        }
    }
}
