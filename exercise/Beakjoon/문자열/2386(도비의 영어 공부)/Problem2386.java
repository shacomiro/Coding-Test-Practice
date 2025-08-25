import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem2386 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input;

        while (!(input = br.readLine()).equals("#")) {
            bw.write(new Solver(input.substring(0, 1).charAt(0), input.substring(2)).solve());
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    static class Solver {
        private char c;
        private String s;

        public Solver(char c, String s) {
            this.c = c;
            this.s = s;
        }

        public String solve() {
            int count = 0;

            for (char sc : s.toLowerCase().toCharArray()) {
                if (sc == c) {
                    count++;
                }
            }

            return c + " " + count;
        }
    }
}
