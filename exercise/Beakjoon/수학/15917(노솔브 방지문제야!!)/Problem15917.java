import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem15917 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int q = Integer.parseInt(br.readLine());
        int[] arr = new int[q];
        for (int i = 0; i < q; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        bw.write(new Solver(q, arr).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private int q;
        private int[] a;

        public Solver(int q, int[] a) {
            this.q = q;
            this.a = a;
        }

        public String solve() {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < q; i++) {
                sb.append(((a[i] & -a[i]) == a[i]) ? 1 : 0).append("\n");
            }

            return sb.toString();
        }
    }
}
