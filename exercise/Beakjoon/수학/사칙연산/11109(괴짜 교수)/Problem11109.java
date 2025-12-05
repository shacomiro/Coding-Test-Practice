import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem11109 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            bw.write(new Solver(d, n, s, p).solve());
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }

    static class Solver {
        private int d, n, s, p;

        public Solver(int d, int n, int s, int p) {
            this.d = d;
            this.n = n;
            this.s = s;
            this.p = p;
        }

        public String solve() {
            int st = n * s;
            int pt = d + n * p;

            return (st == pt) ? "does not matter" : ((st > pt) ? "parallelize" : "do not parallelize");
        }
    }
}
