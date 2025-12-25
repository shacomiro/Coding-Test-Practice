import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem15351 {
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
        private String[] enjoyments;

        public Solver(int n, String[] enjoyments) {
            this.n = n;
            this.enjoyments = enjoyments;
        }

        public String solve() {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < n; i++) {
                int score = 0;

                for (int j = 0; j < enjoyments[i].length(); j++) {
                    if (enjoyments[i].charAt(j) == ' ') {
                        continue;
                    }

                    score += (enjoyments[i].charAt(j) - (int) 'A' + 1);
                }

                sb.append((score == 100) ? "PERFECT LIFE" : score).append("\n");
            }

            return sb.toString();
        }
    }
}
