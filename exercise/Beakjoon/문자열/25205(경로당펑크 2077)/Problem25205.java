import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Set;

public class Problem25205 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();

        bw.write(new Solver(n, s).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private static final Set<Character> VOWEL = Set.of('y', 'u', 'i', 'o', 'p', 'h', 'j', 'k', 'l', 'b', 'n', 'm');
        private int n;
        private String s;

        public Solver(int n, String s) {
            this.n = n;
            this.s = s;
        }

        public String solve() {
            return VOWEL.contains(s.charAt(n - 1)) ? "0" : "1";
        }
    }
}