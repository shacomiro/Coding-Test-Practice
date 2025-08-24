import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem4447 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        bw.write(new Solver(n, arr).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private int n;
        private String[] names;

        public Solver(int n, String[] names) {
            this.n = n;
            this.names = names;
        }

        public String solve() {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < n; i++) {
                int gCnt = 0;
                int bCnt = 0;

                for (char c : names[i].toLowerCase().toCharArray()) {
                    switch (c) {
                        case 'g':
                            gCnt++;
                            break;
                        case 'b':
                            bCnt++;
                            break;
                    }
                }

                sb.append(names[i]).append(" is ");
                if (gCnt > bCnt) {
                    sb.append("GOOD");
                } else if (bCnt > gCnt) {
                    sb.append("A BADDY");
                } else {
                    sb.append("NEUTRAL");
                }
                sb.append("\n");
            }

            return sb.toString();
        }
    }
}