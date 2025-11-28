import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem10865 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[m][2];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        bw.write(new Solver(n, m, arr).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private int n;
        private int m;
        private int[][] friends;

        public Solver(int n, int m, int[][] friends) {
            this.n = n;
            this.m = m;
            this.friends = friends;
        }

        public String solve() {
            int[] counts = new int[n + 1];

            for (int i = 0; i < m; i++) {
                counts[friends[i][0]]++;
                counts[friends[i][1]]++;
            }

            StringBuilder sb = new StringBuilder();
            for(int i = 1; i < n + 1; i++) {
                sb.append(counts[i]).append("\n");
            }

            return sb.toString();
        }
    }
}
