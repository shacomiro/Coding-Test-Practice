import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem25305 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(new Solver(n, k, arr).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private int n;
        private int k;
        private int[] scores;

        public Solver(int n, int k, int[] scores) {
            this.n = n;
            this.k = k;
            this.scores = scores;
        }

        public String solve() {
            Arrays.sort(scores);

            return String.valueOf(scores[n - k]);
        }
    }
}
