import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem14924 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        bw.write(new Solver(s, t, d).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private int s, t, d;

        public Solver(int s, int t, int d) {
            this.s = s;
            this.t = t;
            this.d = d;
        }

        public String solve() {
            return String.valueOf(d / (s * 2) * t);
        }
    }
}
