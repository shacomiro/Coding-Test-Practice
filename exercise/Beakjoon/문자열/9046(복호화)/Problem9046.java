import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem9046 {
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
        private int[] counts;
        private String paragraph;
        public Solver(String paragraph) {
            this.counts = new int[26];
            this.paragraph = paragraph;
        }

        public String solve() {
            for (char c : paragraph.toCharArray()) {
                if (Character.isAlphabetic(c)) {
                    counts[c - 'a']++;
                }
            }

            int max = 0;
            char character = '?';
            boolean isUnique = true;
            for (int i = 0; i < 26; i++) {
                if (counts[i] > max) {
                    max = counts[i];
                    character = (char) (i + 'a');
                    isUnique = true;
                } else if (counts[i] == max) {
                    isUnique = false;
                }
            }

            return String.valueOf((isUnique) ? character : '?');
        }
    }
}

