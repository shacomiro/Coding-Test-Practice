import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem25628 {
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
        private int a, b;

        public Solver(int a, int b) {
            this.a = a;
            this.b = b;
        }

        public String solve() {
            return String.valueOf(Math.min(a / 2, b));
        }
    }
}
