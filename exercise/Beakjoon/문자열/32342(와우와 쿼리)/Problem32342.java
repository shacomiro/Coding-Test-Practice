import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem32342 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int q = Integer.parseInt(br.readLine());
        String[] arr = new String[q];
        for (int i = 0; i < q; i++) {
            arr[i] = br.readLine();
        }

        bw.write(new Solver(q, arr).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private int q;
        private String[] s;

        public Solver(int q, String[] s) {
            this.q = q;
            this.s = s;
        }

        public String solve() {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < q; i++) {
                if (s[i].length() < 3) {
                    sb.append(0).append("\n");
                    continue;
                }

                StringBuilder subStr = new StringBuilder("*").append(s[i].substring(0, 2));
                int count = 0;

                for (int j = 2; j < s[i].length(); j++) {
                    subStr.deleteCharAt(0);
                    subStr.append(s[i].charAt(j));

                    if (subStr.toString().equals("WOW")) {
                        count++;
                    }
                }

                sb.append(count).append("\n");
            }

            return sb.toString();
        }
    }
}
