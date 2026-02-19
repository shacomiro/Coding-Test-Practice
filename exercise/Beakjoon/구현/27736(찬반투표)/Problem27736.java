import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem27736 {
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
        private int[] votes;

        public Solver(int n, int[] votes) {
            this.n = n;
            this.votes = votes;
        }

        public String solve() {
            int approval = 0;
            int rejection = 0;
            int invalidation = 0;

            for (int i = 0; i < n; i++) {
                switch (votes[i]) {
                    case 1:
                        approval++;
                        break;
                    case -1:
                        rejection++;
                        break;
                    case 0:
                        invalidation++;
                        break;
                }
            }

            return (invalidation * 2 >= n) ? "INVALID" : (approval > rejection) ? "APPROVED" : "REJECTED";
        }
    }
}
