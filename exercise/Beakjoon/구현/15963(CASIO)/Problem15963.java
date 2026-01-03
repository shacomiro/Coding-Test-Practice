import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem15963 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());

        bw.write(new Solver(n, m).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private long n, m;

        public Solver(long n, long m) {
            this.n = n;
            this.m = m;
        }

        public String solve() {
            return (n == m) ? "1" : "0";
        }
    }
}
