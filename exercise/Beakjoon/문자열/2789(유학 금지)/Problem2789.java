import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem2789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(new Solver(br.readLine()).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private static final char[] cambridge = { 'C', 'A', 'M', 'B', 'R', 'I', 'D', 'G', 'E' };
        private String word;

        public Solver(String word) {
            this.word = word;
        }

        public String solve() {
            for (char c : cambridge) {
                word = word.replaceAll(String.valueOf(c), "");
            }

            return word;
        }
    }
}
