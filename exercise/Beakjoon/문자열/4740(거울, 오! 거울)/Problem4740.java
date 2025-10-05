import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem4740 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input;

        while (!(input = br.readLine()).equals("***")) {
            bw.write(new Solver(input).solve());
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    static class Solver {
        private String paragraph;

        public Solver(String paragraph) {
            this.paragraph = paragraph;
        }

        public String solve() {
            return new StringBuilder(paragraph).reverse().toString();
        }
    }
}