import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem1673 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        String input;

        while ((input = br.readLine()) != null) {
            st = new StringTokenizer(input);
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            bw.write(new Solver(n, k).solve());
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    static class Solver {
        private int n;
        private int k;

        public Solver(int n, int k) {
            this.n = n;
            this.k = k;
        }

        public String solve() {
            int chicken = n;
            int stamp = n;

            while (stamp >= k) {
                int newChicken = stamp / k;
                chicken += newChicken;
                stamp = (stamp % k) + newChicken;
            }

            return String.valueOf(chicken);
        }
    }
}