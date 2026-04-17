import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem32529 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(new Solver(n, m, arr).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private int n;
        private int m;
        private int[] diet;

        public Solver(int n, int m, int[] diet) {
            this.n = n;
            this.m = m;
            this.diet = diet;
        }

        public String solve() {
            int loss = 0;
            int start = -1;

            for (int i = n - 1; i >= 0; i--) {
                loss += diet[i];

                if (loss >= m) {
                    start = i + 1;
                    break;
                }
            }

            return String.valueOf(start);
        }
    }
}
