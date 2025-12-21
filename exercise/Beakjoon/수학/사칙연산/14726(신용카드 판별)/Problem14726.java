import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Problem14726 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            bw.write(new Solver(br.readLine()).solve());
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    static class Solver {
        private String cardNumber;

        public Solver(String cardNumber) {
            this.cardNumber = cardNumber;
        }

        public String solve() {
            int[] numbers = new int[16];

            for (int i = cardNumber.length() - 1; i >= 0; i--) {
                numbers[i] = Character.getNumericValue(cardNumber.charAt(i)) * ((i % 2 == 0) ? 2 : 1);

                if (numbers[i] >= 10) {
                    String tempNumber = String.valueOf(numbers[i]);
                    numbers[i] = Character.getNumericValue(tempNumber.charAt(0))
                            + Character.getNumericValue(tempNumber.charAt(1));
                }
            }

            return (Arrays.stream(numbers).sum() % 10 == 0) ? "T" : "F";
        }
    }
}
