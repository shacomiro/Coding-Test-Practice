import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem27310 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(new Solver(br.readLine()).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private String imoji;

        public Solver(String imoji) {
            this.imoji = imoji;
        }

        public String solve() {
            int underbar = 0;
            int colon = 0;

            for (int i = 0; i < imoji.length(); i++) {
                char c = imoji.charAt(i);

                if (c == ':') {
                    colon++;
                } else if (c == '_') {
                    underbar++;
                }
            }

            return String.valueOf(imoji.length() + colon + underbar * 5);
        }
    }
}
