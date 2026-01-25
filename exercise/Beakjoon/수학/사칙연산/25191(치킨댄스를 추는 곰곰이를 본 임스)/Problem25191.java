import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem25191 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        bw.write(new Solver(n, a, b).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private int n, a, b;

        public Solver(int n, int a, int b) {
            this.n = n;
            this.a = a;
            this.b = b;
        }

        public String solve() {
            return String.valueOf(Math.min(n, a / 2 + b));
        }
    }
}
