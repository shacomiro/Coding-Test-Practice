import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem29729 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n + m];
        for (int i = 0; i < n + m; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        bw.write(new Solver(s, n, m, arr).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private int s;
        private int u;
        private int n;
        private int m;
        private int[] commands;

        public Solver(int s, int n, int m, int[] commands) {
            this.s = s;
            this.u = 0;
            this.n = n;
            this.m = m;
            this.commands = commands;
        }

        public String solve() {
            for (int i = 0; i < n + m; i++) {
                switch (commands[i]) {
                    case 1:
                        if (u == s) {
                            s *= 2;
                        }
                        u++;
                        break;
                    case 0:
                        u--;
                        break;
                }
            }

            return String.valueOf(s);
        }
    }
}
