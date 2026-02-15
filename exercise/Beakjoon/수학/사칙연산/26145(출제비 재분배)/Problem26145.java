import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem26145 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] s = new int[n];
        for (int i = 0; i < n; i++) {
            s[i] = Integer.parseInt(st.nextToken());
        }
        int[][] t = new int[n][n + m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n + m; j++) {
                t[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bw.write(new Solver(n, m, s, t).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private int n;
        private int m;
        private int[] s;
        private int[][] t;

        public Solver(int n, int m, int[] s, int[][] t) {
            this.n = n;
            this.m = m;
            this.s = s;
            this.t = t;
        }

        public String solve() {
            int[] money = new int[n + m];
            for (int i = 0; i < n; i++) {
                money[i] = s[i];
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n + m; j++) {
                    money[i] -= t[i][j];
                    money[j] += t[i][j];
                }
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n + m; i++) {
                sb.append(money[i]).append(" ");
            }

            return sb.toString();
        }
    }
}
