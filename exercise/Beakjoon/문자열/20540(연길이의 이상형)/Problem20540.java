import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem20540 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(new Solver(br.readLine()).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private String mbti;

        public Solver(String mbti) {
            this.mbti = mbti;
        }

        public String solve() {
            return new StringBuilder(4)
                    .append(mbti.charAt(0) == 'E' ? 'I' : 'E')
                    .append(mbti.charAt(1) == 'S' ? 'N' : 'S')
                    .append(mbti.charAt(2) == 'T' ? 'F' : 'T')
                    .append(mbti.charAt(3) == 'J' ? 'P' : 'J')
                    .toString();
        }
    }
}
