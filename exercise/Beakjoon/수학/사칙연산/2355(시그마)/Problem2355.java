import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem2355 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        bw.write(new Solver(a, b).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private long a;
        private long b;

        public Solver(long a, long b) {
            this.a = a;
            this.b = b;
        }

        public String solve() {
            long min = Math.min(a, b);
            long max = Math.max(a, b);

            return String.valueOf((min + max) * (max - min + 1) / 2);
        }
    }
}
