import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem27918 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        char[] arr = new char[n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine().charAt(0);
        }

        bw.write(new Solver(n, arr).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private int n;
        private char[] winners;

        public Solver(int n, char[] winners) {
            this.n = n;
            this.winners = winners;
        }

        public String solve() {
            int dalgu = 0;
            int ponix = 0;

            for (int i = 0; i < n; i++) {
                switch (winners[i]) {
                    case 'D':
                        dalgu++;
                        break;
                    case 'P':
                        ponix++;
                        break;
                }

                if (Math.abs(dalgu - ponix) >= 2) {
                    break;
                }
            }

            return dalgu + ":" + ponix;
        }
    }
}
