import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem30008 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[k];
        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(new Solver(n, k, arr).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private int n;
        private int k;
        private int[] d;

        public Solver(int n, int k, int[] d) {
            this.n = n;
            this.k = k;
            this.d = d;
        }

        public String solve() {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < k; i++) {
                sb.append(getGrade(d[i] * 100 / n)).append(" ");
            }

            return sb.toString().trim();
        }

        private int getGrade(int p) {
            if (0 <= p && p <= 4) {
                return 1;
            } else if (4 < p && p <= 11) {
                return 2;
            } else if (11 < p && p <= 23) {
                return 3;
            } else if (23 < p && p <= 40) {
                return 4;
            } else if (40 < p && p <= 60) {
                return 5;
            } else if (60 < p && p <= 77) {
                return 6;
            } else if (77 < p && p <= 89) {
                return 7;
            } else if (89 < p && p <= 96) {
                return 8;
            } else {
                return 9;
            }
        }
    }
}
