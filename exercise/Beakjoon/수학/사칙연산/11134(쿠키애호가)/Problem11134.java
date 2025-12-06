import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem11134 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            bw.write(new Solver(n, c).solve());
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    static class Solver {
        private int n;
        private int c;

        public Solver(int n, int c) {
            this.n = n;
            this.c = c;
        }

        public String solve() {
            return String.valueOf((n / c) + (n % c != 0 ? 1 : 0));
        }
    }
}
