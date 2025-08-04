import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Problem3003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[6];
        for (int i = 0; i < 6; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(new Solver(arr).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private int[] peices;

        public Solver(int[] peices) {
            this.peices = peices;
        }

        public String solve() {
            int[] required = new int[] { 1, 1, 2, 2, 2, 8 };

            for (int i = 0; i < 6; i++) {
                required[i] -= peices[i];
            }

            StringBuilder sb = new StringBuilder();
            for (int rq : required) {
                sb.append(rq).append(" ");
            }

            return sb.toString();
        }
    }
}