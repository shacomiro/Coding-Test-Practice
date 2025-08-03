import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class Problem11478 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(new Solver(br.readLine()).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private String s;
        private Set<String> set;

        public Solver(String s) {
            this.s = s;
            this.set = new HashSet<>();
        }

        public String solve() {
            for (int len = 1; len <= s.length(); len++) {
                for (int i = 0; i + len - 1 < s.length(); i++) {
                    set.add(s.substring(i, i + len));
                }
            }

            return String.valueOf(set.size());
        }
    }
}
