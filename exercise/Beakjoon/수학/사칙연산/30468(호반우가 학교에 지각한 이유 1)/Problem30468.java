import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem30468 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int i = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        bw.write(new Solver(s, d, i, l, n).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private int s;
        private int d;
        private int i;
        private int l;
        private int n;

        public Solver(int s, int d, int i, int l, int n) {
            this.s = s;
            this.d = d;
            this.i = i;
            this.l = l;
            this.n = n;
        }

        public String solve() {
            return String.valueOf(Math.max(0, (n * 4) - (s + d + i + l)));
        }
    }
}
