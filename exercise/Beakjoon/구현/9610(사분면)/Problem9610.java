import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem9610 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bw.write(new Solver(n, arr).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private int n;
        private int[][] coordinates;

        public Solver(int n, int[][] coordinates) {
            this.n = n;
            this.coordinates = coordinates;
        }

        public String solve() {
            int q1 = 0;
            int q2 = 0;
            int q3 = 0;
            int q4 = 0;
            int axis = 0;

            for (int i = 0; i < n; i++) {
                int x = coordinates[i][0];
                int y = coordinates[i][1];

                if (x == 0 || y == 0) {
                    axis++;
                } else if (x > 0 && y > 0) {
                    q1++;
                } else if (x < 0 && y > 0) {
                    q2++;
                } else if (x < 0 && y < 0) {
                    q3++;
                } else {
                    q4++;
                }
            }

            StringBuilder sb = new StringBuilder();
            sb.append("Q1: ").append(q1).append("\n")
                    .append("Q2: ").append(q2).append("\n")
                    .append("Q3: ").append(q3).append("\n")
                    .append("Q4: ").append(q4).append("\n")
                    .append("AXIS: ").append(axis);

            return sb.toString();
        }
    }
}
