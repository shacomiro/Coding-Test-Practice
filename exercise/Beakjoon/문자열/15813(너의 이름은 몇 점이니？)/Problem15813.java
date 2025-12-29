import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem15813 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(new Solver(Integer.parseInt(br.readLine()), br.readLine()).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private int length;
        private String name;

        public Solver(int length, String name) {
            this.length = length;
            this.name = name;
        }

        public String solve() {
            int score = 0;

            for (int i = 0; i < length; i++) {
                score += (int) name.charAt(i) - 64;
            }

            return String.valueOf(score);
        }
    }
}
