import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem13136 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long r = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());
        long n = Long.parseLong(st.nextToken());

        bw.write(new Solver(r, c, n).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private long r;
        private long c;
        private long n;

        public Solver(long r, long c, long n) {
            this.r = r;
            this.c = c;
            this.n = n;
        }

        public String solve() {
            long row = r / n + (r % n != 0 ? 1 : 0);
            long col = c / n + (c % n != 0 ? 1 : 0);
            
            return String.valueOf(row * col);
        }
    }
}
