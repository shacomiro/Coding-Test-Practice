import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem2953 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int[][] arr = new int[5][4];
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bw.write(new Solver(arr).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private int[][] scores;

        public Solver(int[][] scores) {
            this.scores = scores;
        }

        public String solve() {
            int id = 0;
            int max = 0;

            for (int i = 0; i < 5; i++) {
                int sum = 0;
                for (int s : scores[i]) {
                    sum += s;
                }

                if (sum > max) {
                    id = i + 1;
                    max = sum;
                }
            }

            return id + " " + max;
        }
    }
}
