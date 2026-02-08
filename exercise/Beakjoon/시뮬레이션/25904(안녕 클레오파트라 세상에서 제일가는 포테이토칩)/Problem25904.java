import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem25904 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(new Solver(n, x, arr).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private int n;
        private int x;
        private int[] t;

        public Solver(int n, int x, int[] t) {
            this.n = n;
            this.x = x;
            this.t = t;
        }

        public String solve() {
            int curr = 0;

            while(t[curr] >= x) {
                curr = (curr + 1) % n;
                x++;
            }

            return String.valueOf(curr + 1);
        }
    }
}
