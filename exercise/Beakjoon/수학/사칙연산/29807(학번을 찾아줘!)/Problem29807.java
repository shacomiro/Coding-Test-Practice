import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem29807 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[5];
        for (int i = 0; i < t; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(new Solver(arr).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private int[] scores;

        public Solver(int[] scores) {
            this.scores = scores;
        }

        public String solve() {
            int val1 = Math.abs(scores[0] - scores[2]) * ((scores[0] > scores[2]) ? 508 : 108);
            int val2 = Math.abs(scores[1] - scores[3]) * ((scores[1] > scores[3]) ? 212 : 305);
            int val3 = scores[4] * 707;

            return String.valueOf((val1 + val2 + val3) * 4763);
        }
    }
}
