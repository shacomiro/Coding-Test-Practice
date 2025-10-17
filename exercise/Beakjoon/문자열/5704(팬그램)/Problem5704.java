import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem5704 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input;

        while (!(input = br.readLine()).equals("*")) {
            bw.write(new Solver(input).solve());
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    static class Solver {
        private boolean[] alphabet;
        private String paragraph;

        public Solver(String paragraph) {
            this.alphabet = new boolean[26];
            this.paragraph = paragraph;
        }

        public String solve() {
            int count = 0;

            for (int i = 0; i < paragraph.length(); i++) {
                if (paragraph.charAt(i) != ' ' && !alphabet[paragraph.charAt(i) - 'a']) {
                    alphabet[paragraph.charAt(i) - 'a'] = true;
                    count++;
                }
            }

            return (count == 26) ? "Y" : "N";
        }
    }
}
