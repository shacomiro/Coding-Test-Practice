import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem30031 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        bw.write(new Solver(n, arr).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private int n;
        private int[][] money;

        public Solver(int n, int[][] money) {
            this.n = n;
            this.money = money;
        }

        public String solve() {
            int sum = 0;

            for (int i = 0; i < n; i++) {
                switch (money[i][0]) {
                    case 136:
                        sum += 1000;
                        break;
                    case 142:
                        sum += 5000;
                        break;
                    case 148:
                        sum += 10000;
                        break;
                    case 154:
                        sum += 50000;
                        break;
                }
            }

            return String.valueOf(sum);
        }
    }
}
