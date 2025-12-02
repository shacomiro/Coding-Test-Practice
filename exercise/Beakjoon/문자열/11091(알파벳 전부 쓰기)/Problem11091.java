import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem11091 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        bw.write(new Solver(n, arr).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private int n;
        private String[] paragraph;

        public Solver(int n, String[] paragraph) {
            this.n = n;
            this.paragraph = paragraph;
        }

        public String solve() {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < n; i++) {
                boolean[] isExisting = new boolean[26];

                for (int j = 0; j < paragraph[i].length(); j++) {
                    char c = paragraph[i].charAt(j);
                    if ('a' <= c && c <= 'z') {
                        isExisting[c - 'a'] = true;
                    } else if ('A' <= c && c <= 'Z') {
                        isExisting[c - 'A'] = true;
                    }
                }

                StringBuilder missing = new StringBuilder();
                for (int j = 0; j < 26; j++) {
                    if (!isExisting[j]) {
                        missing.append((char) (j + 'a'));
                    }
                }

                sb.append((missing.length() > 0) ? ("missing " + missing.toString()) : "pangram")
                        .append("\n");
            }

            return sb.toString();
        }
    }
}
