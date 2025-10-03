import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem4435 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int[] arr1 = new int[6];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 6; j++) {
                arr1[j] = Integer.parseInt(st.nextToken());
            }
            int[] arr2 = new int[7];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 7; j++) {
                arr2[j] = Integer.parseInt(st.nextToken());
            }
            bw.write(new Solver(i, arr1, arr2).solve());
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    static class Solver {
        private static final int[] gPoints = { 1, 2, 3, 3, 4, 10 };
        private static final int[] sPoints = { 1, 2, 2, 2, 3, 5, 10 };
        private int battleId;
        private int[] gandalf;
        private int[] sauron;

        public Solver(int battleId, int[] gandalf, int[] sauron) {
            this.battleId = battleId;
            this.gandalf = gandalf;
            this.sauron = sauron;
        }

        public String solve() {
            int gScore = 0;
            int sScore = 0;

            for (int i = 0; i < 6; i++) {
                gScore += gandalf[i] * gPoints[i];
            }
            for (int i = 0; i < 7; i++) {
                sScore += sauron[i] * sPoints[i];
            }

            return "Battle " + (battleId + 1) + ": " + ((gScore == sScore) ? "No victor on this battle field"
                    : (gScore > sScore) ? "Good triumphs over Evil" : "Evil eradicates all trace of Good");
        }
    }
}
