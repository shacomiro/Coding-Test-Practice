import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem25640 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        bw.write(new Solver(s, n, arr).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private String jinhoMbti;
        private int n;
        private String[] otherMbti;

        public Solver(String jinhoMbti, int n, String[] otherMbti) {
            this.jinhoMbti = jinhoMbti;
            this.n = n;
            this.otherMbti = otherMbti;
        }

        public String solve() {
            int count = 0;

            for (int i = 0; i < n; i++) {
                if (jinhoMbti.equals(otherMbti[i])) {
                    count++;
                }
            }

            return String.valueOf(count);
        }
    }
}
