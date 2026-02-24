import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem28281 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(new Solver(n, x, a).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private int n;
        private int x;
        private int[] a;

        public Solver(int n, int x, int[] a) {
            this.n = n;
            this.x = x;
            this.a = a;
        }

        public String solve() {
            int lt = 0;
            int rt = 1;
            long sum = (a[0] * x) + (a[1] * x);
            long min = sum;

            while (rt < n - 1) {
                sum += (a[rt++ + 1] * x) - (a[lt++] * x);
                min = Math.min(min, sum);
            }

            return String.valueOf(min);
        }
    }
}
