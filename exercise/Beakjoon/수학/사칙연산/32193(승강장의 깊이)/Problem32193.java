import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem32193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr1[i] = Integer.parseInt(st.nextToken());
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(new Solver(n, arr1, arr2).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private int n;
        private int[] a;
        private int[] b;

        public Solver(int n, int[] a, int[] b) {
            this.n = n;
            this.a = a;
            this.b = b;
        }

        public String solve() {
            StringBuilder sb = new StringBuilder();
            int g = 0;
            int p = 0;

            for (int i = 0; i < n; i++) {
                g += a[i];
                p += b[i];

                sb.append(g - p).append("\n");
            }

            return sb.toString();
        }
    }
}
