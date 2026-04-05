import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem31922 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        bw.write(new Solver(a, p, c).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private int a, p, c;

        public Solver(int a, int p, int c) {
            this.a = a;
            this.p = p;
            this.c = c;
        }

        public String solve() {
            return String.valueOf(Math.max(a + c, p));
        }
    }
}
