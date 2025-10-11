import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Problem5176 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[] arr = new int[p];
            for (int j = 0; j < p; j++) {
                arr[j] = Integer.parseInt(br.readLine());
            }
            bw.write(new Solver(p, m, arr).solve());
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    static class Solver {
        private int p;
        private int[] req;
        private Set<Integer> seats;

        public Solver(int p, int m, int[] req) {
            this.p = p;
            this.req = req;
            this.seats = new HashSet<>(m);
        }

        public String solve() {
            int count = 0;

            for (int i = 0; i < p; i++) {
                if (seats.contains(req[i])) {
                    count++;
                } else {
                    seats.add(req[i]);
                }
            }

            return String.valueOf(count);
        }
    }
}
