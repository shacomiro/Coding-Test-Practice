import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem2506 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(new Solver(n, arr).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private int n;
        private int[] results;

        public Solver(int n, int[] results) {
            this.n = n;
            this.results = results;
        }

        public String solve() {
            int scores = 0;
            int point = 1;

            for (int i = 0; i < n; i++) {
                if (results[i] == 1) {
                    scores += point;
                    point++;
                } else {
                    point = 1;
                }
            }

            return String.valueOf(scores);
        }
    }
}
