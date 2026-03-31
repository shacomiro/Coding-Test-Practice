import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem31822 {
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
        private String retakeCode;
        private int n;
        private String[] avaiableCode;

        public Solver(String retakeCode, int n, String[] avaiableCode) {
            this.retakeCode = retakeCode;
            this.n = n;
            this.avaiableCode = avaiableCode;
        }

        public String solve() {
            String frontCode = retakeCode.substring(0, 5);
            int count = 0;

            for (int i = 0; i < n; i++) {
                if (avaiableCode[i].substring(0, 5).equals(frontCode)) {
                    count++;
                }
            }

            return String.valueOf(count);
        }
    }
}
