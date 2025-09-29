import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Set;

public class Problem3181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(new Solver(br.readLine()).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private static final Set<String> ignores = Set.of("i", "pa", "te", "ni", "niti", "a", "ali", "nego", "no",
                "ili");
        private String[] words;

        public Solver(String words) {
            this.words = words.split(" ");
        }

        public String solve() {
            StringBuilder sb = new StringBuilder();
            sb.append(Character.toUpperCase(words[0].charAt(0)));
            for (int i = 1; i < words.length; i++) {
                if (!ignores.contains(words[i])) {
                    sb.append(Character.toUpperCase(words[i].charAt(0)));
                }
            }

            return sb.toString();
        }
    }
}
