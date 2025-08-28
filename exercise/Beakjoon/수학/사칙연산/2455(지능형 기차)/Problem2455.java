import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem2455 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int[][] arr = new int[4][2];
        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        bw.write(new Solver(arr).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private int[][] passengers;

        public Solver(int[][] passengers) {
            this.passengers = passengers;
        }

        public String solve() {
            int max = 0;
            int current = 0;

            for (int i = 0; i < 4; i++) {
                current -= passengers[i][0];
                current += passengers[i][1];

                max = Math.max(max, Math.min(current, 10000));
            }

            return String.valueOf(max);
        }
    }
}
