import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem29766 {
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
            int count = 0;

            while (str.contains("DKSH")) {
                str = str.replaceFirst("DKSH", "");
                count++;
            }

            return String.valueOf(count);
        }
    }
}
