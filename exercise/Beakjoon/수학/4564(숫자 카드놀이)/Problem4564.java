import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem4564 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input;

        while (!(input = br.readLine()).equals("0")) {
            bw.write(new Solver(Integer.parseInt(input)).solve());
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    static class Solver {
        private int s;

        public Solver(int s) {
            this.s = s;
        }

        public String solve() {
            StringBuilder sb = new StringBuilder();
            int curr = s;

            while (curr >= 10) {
                sb.append(curr).append(" ");

                int next = 1;
                int temp = curr;

                while (temp > 0) {
                    next *= temp % 10;
                    temp /= 10;
                }

                curr = next;
            }

            return sb.append(curr).toString();
        }
    }
}
