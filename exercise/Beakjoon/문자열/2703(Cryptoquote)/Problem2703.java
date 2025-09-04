import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem2703 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String s1 = br.readLine();
            String s2 = br.readLine();
            bw.write(new Solver(s1, s2).solve());
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    static class Solver {
        private String message;
        private String decodeRule;

        public Solver(String message, String decodeRule) {
            this.message = message;
            this.decodeRule = decodeRule;
        }

        public String solve() {
            StringBuilder sb = new StringBuilder(message.length());
            for (int i = 0; i < message.length(); i++) {
                char c = message.charAt(i);
                sb.append((c != ' ') ? decodeRule.charAt(c - 'A') : ' ');
            }

            return sb.toString();
        }
    }
}
