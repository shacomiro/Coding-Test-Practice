import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem31833 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
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
            StringBuilder sbX = new StringBuilder();
            StringBuilder sbY = new StringBuilder();

            for (int i = 0; i < n; i++) {
                sbX.append(a[i]);
                sbY.append(b[i]);
            }

            long x = Long.parseLong(sbX.toString());
            long y = Long.parseLong(sbY.toString());

            return String.valueOf(Math.min(x, y));
        }
    }
}
