import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem14935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(new Solver(br.readLine()).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private String x;

        public Solver(String x) {
            this.x = x;
        }

        public String solve() {
            String prev = x;
            String next;

            while (!(next = String.valueOf(Character.getNumericValue(prev.charAt(0)) * prev.length())).equals(prev)) {
                prev = next;
            }

            return (prev.equals(next)) ? "FA" : "NFA";
        }
    }
}
