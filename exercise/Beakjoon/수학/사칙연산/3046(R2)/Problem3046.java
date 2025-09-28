import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem3046 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int r1 = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        bw.write(new Solver(r1, s).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private int r1;
        private int s;

        public Solver(int r1, int s) {
            this.r1 = r1;
            this.s = s;
        }

        public String solve() {
            return String.valueOf(s * 2 - r1);
        }
    }
}
