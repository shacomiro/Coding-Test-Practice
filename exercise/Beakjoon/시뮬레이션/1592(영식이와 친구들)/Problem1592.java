import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem1592 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        bw.write(new Solver(n, m, l).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private int n;
        private int m;
        private int l;

        public Solver(int n, int m, int l) {
            this.n = n;
            this.m = m;
            this.l = l;
        }

        public String solve() {
            int[] receivedCounts = new int[n];
            int currentPerson = 0;
            int passCount = 0;

            while (true) {
                receivedCounts[currentPerson]++;

                if (receivedCounts[currentPerson] == m) {
                    break;
                } else if (receivedCounts[currentPerson] % 2 == 1) {
                    currentPerson = (currentPerson + l) % n;
                } else {
                    currentPerson = (currentPerson - l + n) % n;
                }

                passCount++;
            }

            return String.valueOf(passCount);
        }
    }
}
