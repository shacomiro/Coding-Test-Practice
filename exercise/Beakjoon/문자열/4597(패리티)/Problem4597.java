import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem4597 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input;

        while (!(input = br.readLine()).equals("#")) {
            bw.write(new Solver(input).solve());
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    static class Solver {
        private String bitString;

        public Solver(String bitString) {
            this.bitString = bitString;
        }

        public String solve() {
            int bitCount = 0;

            for (int i = 0; i < bitString.length() - 1; i++) {
                if (bitString.charAt(i) == '1') {
                    bitCount++;
                }
            }

            bitString = (bitString.charAt(bitString.length() - 1) == 'e')
                    ? bitString.replaceFirst("e", (bitCount % 2 == 0) ? "0" : "1")
                    : bitString.replaceFirst("o", (bitCount % 2 == 0) ? "1" : "0");

            return String.valueOf(bitString);
        }
    }
}
