import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem14724 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[9][n];
        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bw.write(new Solver(n, arr).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private static final String[] CLUB_NAMES = new String[] { "PROBRAIN", "GROW", "ARGOS", "ADMIN", "ANT", "MOTION",
                "SPG", "COMON", "ALMIGHTY" };
        private int n;
        private int[][] clubs;

        public Solver(int n, int[][] clubs) {
            this.n = n;
            this.clubs = clubs;
        }

        public String solve() {
            String club = "";
            int maxSolved = 0;

            for (int i = 0; i < clubs.length; i++) {
                for (int j = 0; j < clubs[i].length; j++) {
                    if (maxSolved < clubs[i][j]) {
                        maxSolved = clubs[i][j];
                        club = CLUB_NAMES[i];
                    }
                }
            }

            return club;
        }
    }
}
