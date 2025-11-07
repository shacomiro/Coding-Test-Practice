import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem9517 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int k = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        Solver.Answer[] arr = new Solver.Answer[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = new Solver.Answer(Integer.parseInt(st.nextToken()), st.nextToken().charAt(0));
        }

        bw.write(new Solver(k, n, arr).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private int k;
        private int n;
        private Answer[] answers;

        public Solver(int k, int n, Answer[] answers) {
            this.k = k;
            this.n = n;
            this.answers = answers;
        }

        public String solve() {
            int time = 0;

            for (int i = 0; i < n; i++) {
                time += answers[i].getTime();

                if (time >= 210) {
                    break;
                }

                if (answers[i].getResult() == 'T') {
                    k = k % 8 + 1;
                }
            }

            return String.valueOf(k);
        }

        private static class Answer {
            private int time;
            private char result;

            public Answer(int time, char result) {
                this.time = time;
                this.result = result;
            }

            public char getResult() {
                return result;
            }

            public int getTime() {
                return time;
            }
        }
    }
}
