import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem30868 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        int[] arr = new int[t];
        for (int i = 0; i < t; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        bw.write(new Solver(t, arr).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private int t;
        private int[] votes;

        public Solver(int t, int[] votes) {
            this.t = t;
            this.votes = votes;
        }

        public String solve() {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < t; i++) {
                sb.append("++++ ".repeat(votes[i] / 5)).append("|".repeat(votes[i] % 5)).append("\n");
            }

            return sb.toString();
        }
    }
}
