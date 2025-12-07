import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem11721 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(new Solver(br.readLine()).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private String str;

        public Solver(String str) {
            this.str = str;
        }

        public String solve() {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < str.length(); i++) {
                sb.append(str.charAt(i));

                if ((i + 1) % 10 == 0) {
                    sb.append("\n");
                }
            }

            return sb.toString();
        }
    }
}