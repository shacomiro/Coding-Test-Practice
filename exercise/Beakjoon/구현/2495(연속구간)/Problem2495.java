import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem2495 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] arr = new String[3];
        for (int i = 0; i < 3; i++) {
            arr[i] = br.readLine();
        }

        bw.write(new Solver(arr).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private String[] numbers;

        public Solver(String[] numbers) {
            this.numbers = numbers;
        }

        public String solve() {
            StringBuilder sb = new StringBuilder();

            for (String number : numbers) {
                int max = 1;
                int count = 1;

                for (int i = 1; i < number.length(); i++) {
                    if (number.charAt(i) == number.charAt(i - 1)) {
                        count++;
                    } else {
                        max = Math.max(max, count);
                        count = 1;
                    }
                }
                max = Math.max(max, count);

                sb.append(max).append("\n");
            }

            return sb.toString();
        }
    }
}
