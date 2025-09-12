import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem3034 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        bw.write(new Solver(n, w, h, arr).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private int n;
        private int w;
        private int h;
        private int d;
        private int[] matches;

        public Solver(int n, int w, int h, int[] matches) {
            this.n = n;
            this.w = w;
            this.h = h;
            this.d = (int) Math.sqrt(w * w + h * h);
            this.matches = matches;
        }

        public String solve() {
            StringBuilder sb = new StringBuilder();
            int max = Math.max(Math.max(w, h), d);

            for (int i = 0; i < n; i++) {
                sb.append((matches[i] <= max) ? "DA" : "NE").append("\n");
            }

            return sb.toString();
        }
    }
}
