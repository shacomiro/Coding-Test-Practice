import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem1598 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        bw.write(new Solver(a, b).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private int a;
        private int b;

        public Solver(int a, int b) {
            this.a = a - 1;
            this.b = b - 1;
        }

        public String solve() {
            int ax = a / 4;
            int ay = a % 4;
            int bx = b / 4;
            int by = b % 4;

            int dx = Math.abs(ax - bx);
            int dy = Math.abs(ay - by);

            return String.valueOf(dx + dy);
        }
    }
}

