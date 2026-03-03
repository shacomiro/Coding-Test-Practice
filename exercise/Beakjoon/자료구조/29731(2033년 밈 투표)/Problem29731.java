import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Problem29731 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list.add(br.readLine());
        }

        bw.write(new Solver(n, list).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private static final Set<String> ORIGINAL_PROMISE = Set.of("Never gonna give you up",
                "Never gonna let you down",
                "Never gonna run around and desert you",
                "Never gonna make you cry",
                "Never gonna say goodbye",
                "Never gonna tell a lie and hurt you",
                "Never gonna stop");
        private int n;
        private List<String> s;

        public Solver(int n, List<String> s) {
            this.n = n;
            this.s = s;
        }

        public String solve() {
            for (int i = 0; i < n; i++) {
                if (!ORIGINAL_PROMISE.contains(s.get(i))) {
                    return "Yes";
                }
            }

            return "No";
        }
    }
}
