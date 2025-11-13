import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem9243 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String s1 = br.readLine();
        String s2 = br.readLine();

        bw.write(new Solver(n, s1, s2).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private int n;
        private String before;
        private String after;

        public Solver(int n, String before, String after) {
            this.n = n;
            this.before = before;
            this.after = after;
        }

        public String solve() {
            boolean result;

            if (n % 2 == 0) {
                result = before.equals(after);
            } else {
                result = flipedString(before).equals(after);
            }

            return "Deletion " + (result ? "succeeded" : "failed");
        }

        private String flipedString(String s) {
            StringBuilder flipped = new StringBuilder();

            for (char c : s.toCharArray()) {
                flipped.append(c == '0' ? '1' : '0');
            }

            return flipped.toString();
        }
    }
}
