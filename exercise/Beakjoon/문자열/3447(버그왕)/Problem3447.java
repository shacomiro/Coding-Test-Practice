import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem3447 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String input;

        while ((input = br.readLine()) != null) {
            sb.append(input).append("\n");
        }
        bw.write(new Solver(sb.toString()).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private String code;

        public Solver(String code) {
            this.code = code;
        }

        public String solve() {
            while (code.contains("BUG")) {
                code = code.replace("BUG", "");
            }

            return code;
        }
    }
}
