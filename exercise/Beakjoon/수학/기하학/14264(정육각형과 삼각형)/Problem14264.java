import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem14264 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(new Solver(Integer.parseInt(br.readLine())).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private int l;

        public Solver(int l) {
            this.l = l;
        }

        public String solve() {
            return String.valueOf((Math.sqrt(3) / 4.0) * l * l);
        }
    }
}
