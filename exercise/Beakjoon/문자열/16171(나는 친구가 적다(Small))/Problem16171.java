import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem16171 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(new Solver(br.readLine(), br.readLine()).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private String s;
        private String k;

        public Solver(String s, String k) {
            this.s = s;
            this.k = k;
        }

        public String solve() {
            return (s.replaceAll("[0-9]", "").contains(k)) ? "1" : "0";
        }
    }
}
