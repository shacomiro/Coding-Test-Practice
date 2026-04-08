import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem32209 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int q = Integer.parseInt(br.readLine());
        int[][] arr = new int[q][2];
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        bw.write(new Solver(q, arr).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private int q;
        private int[][] events;

        public Solver(int q, int[][] events) {
            this.q = q;
            this.events = events;
        }

        public String solve() {
            int p = 0;

            for (int i = 0; i < q; i++) {
                switch (events[i][0]) {
                    case 1:
                        p += events[i][1];
                        break;
                    case 2:
                        p -= events[i][1];
                        break;
                }

                if (p < 0) {
                    return "Adios";
                }
            }

            return "See you next month";
        }
    }
}
