import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem27323 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());

        bw.write(new Solver(a, b).solve());
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
            return String.valueOf(a * b);
        }
    }
}