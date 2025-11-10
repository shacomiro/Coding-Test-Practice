import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem8932 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            bw.write(new Solver(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())).solve());
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    static class Solver {
        private int g1, g2, g3, g4, g5, g6, g7;

        public Solver(int g1, int g2, int g3, int g4, int g5, int g6, int g7) {
            this.g1 = g1;
            this.g2 = g2;
            this.g3 = g3;
            this.g4 = g4;
            this.g5 = g5;
            this.g6 = g6;
            this.g7 = g7;
        }

        public String solve() {
            int s1 = (int) (9.23076 * Math.pow(26.7 - g1, 1.835));
            int s2 = (int) (1.84523 * Math.pow(g2 - 75, 1.348));
            int s3 = (int) (56.0211 * Math.pow(g3 - 1.5, 1.05));
            int s4 = (int) (4.99087 * Math.pow(42.5 - g4, 1.81));
            int s5 = (int) (0.188807 * Math.pow(g5 - 210, 1.41));
            int s6 = (int) (15.9803 * Math.pow(g6 - 3.8, 1.04));
            int s7 = (int) (0.11193 * Math.pow(254 - g7, 1.88));

            return String.valueOf(s1 + s2 + s3 + s4 + s5 + s6 + s7);
        }
    }
}
