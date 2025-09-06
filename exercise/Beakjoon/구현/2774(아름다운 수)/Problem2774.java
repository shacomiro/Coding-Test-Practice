import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class Problem2774 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            bw.write(new Solver(br.readLine()).solve());
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    static class Solver {
        private Set<Character> numbersSet;
        private String x;

        public Solver(String x) {
            this.numbersSet = new HashSet<>(10);
            this.x = x;
        }

        public String solve() {
            for (int i = 0; i < x.length(); i++) {
                numbersSet.add(x.charAt(i));
            }

            return String.valueOf(numbersSet.size());
        }
    }
}
