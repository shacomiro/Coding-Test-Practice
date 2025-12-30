import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem15820 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int s1 = Integer.parseInt(st.nextToken());
        int s2 = Integer.parseInt(st.nextToken());
        int[][] arr1 = new int[s1][2];
        for (int i = 0; i < s1; i++) {
            st = new StringTokenizer(br.readLine());
            arr1[i][0] = Integer.parseInt(st.nextToken());
            arr1[i][1] = Integer.parseInt(st.nextToken());
        }
        int[][] arr2 = new int[s2][2];
        for (int i = 0; i < s2; i++) {
            st = new StringTokenizer(br.readLine());
            arr2[i][0] = Integer.parseInt(st.nextToken());
            arr2[i][1] = Integer.parseInt(st.nextToken());
        }

        bw.write(new Solver(s1, s2, arr1, arr2).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private int s1;
        private int s2;
        private int[][] sampleTestCases;
        private int[][] systemTestCases;

        public Solver(int s1, int s2, int[][] sampleTestCases, int[][] systemTestCases) {
            this.s1 = s1;
            this.s2 = s2;
            this.sampleTestCases = sampleTestCases;
            this.systemTestCases = systemTestCases;
        }

        public String solve() {
            for (int i = 0; i < s1; i++) {
                if (sampleTestCases[i][0] != sampleTestCases[i][1]) {
                    return "Wrong Answer";
                }
            }

            for (int i = 0; i < s2; i++) {
                if (systemTestCases[i][0] != systemTestCases[i][1]) {
                    return "Why Wrong!!!";
                }
            }

            return "Accepted";
        }
    }
}
