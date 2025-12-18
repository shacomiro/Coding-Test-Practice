import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem13752 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        bw.write(new Solver(arr).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private int[] k;

        public Solver(int[] k) {
            this.k = k;
        }

        public String solve() {
            StringBuilder sb = new StringBuilder();

            for (int count : k) {
                for (int i = 0; i < count; i++) {
                    sb.append("=");
                }
                sb.append("\n");
            }

            return sb.toString();
        }
    }
}
