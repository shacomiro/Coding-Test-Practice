import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem25965 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int m = Integer.parseInt(br.readLine());
            int[][] arr = new int[m][3];
            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < 3; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());

            bw.write(new Solver(arr, k, d, a).solve());
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    static class Solver {
        private int[][] missions;
        private int k, d, a;

        public Solver(int[][] missions, int k, int d, int a) {
            this.missions = missions;
            this.k = k;
            this.d = d;
            this.a = a;
        }

        public String solve() {
            long donation = 0;

            for (int[] mission : missions) {
                donation += Math.max(0, ((long) k * mission[0]) - ((long) d * mission[1]) + ((long) a * mission[2]));
            }

            return String.valueOf(donation);
        }
    }
}
