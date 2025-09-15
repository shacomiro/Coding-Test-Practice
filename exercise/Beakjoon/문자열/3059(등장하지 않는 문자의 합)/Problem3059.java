import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem3059 {
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
        private boolean[] alphabets;
        private String s;

        public Solver(String s) {
            this.alphabets = new boolean[26];
            this.s = s;
        }

        public String solve() {
            int sum = 2015;

            for (int i = 0; i < s.length(); i++) {
                if (!alphabets[s.charAt(i) - 'A']) {
                    alphabets[s.charAt(i) - 'A'] = true;
                    sum -= s.charAt(i);
                }
            }

            return String.valueOf(sum);
        }
    }
}
