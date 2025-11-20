import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem10103 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        bw.write(new Solver(n, arr).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private int n;
        private int[][] rounds;

        public Solver(int n, int[][] rounds) {
            this.n = n;
            this.rounds = rounds;
        }

        public String solve() {
            int cy = 100;
            int sd = 100;

            for (int i = 0; i < n; i++) {
                if (rounds[i][0] > rounds[i][1]) {
                    sd -= rounds[i][0];
                } else if (rounds[i][0] < rounds[i][1]) {
                    cy -= rounds[i][1];
                }
            }

            return cy + "\n" + sd;
        }
    }
}
