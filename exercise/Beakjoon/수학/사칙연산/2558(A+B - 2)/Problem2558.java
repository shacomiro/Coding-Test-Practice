import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem2558 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(new Solver(Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine())).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private int a;
        private int b;

        public Solver(int a, int b) {
            this.a = a;
            this.b = b;
        }

        public String solve() {
            return String.valueOf(a + b);
        }
    }
}
