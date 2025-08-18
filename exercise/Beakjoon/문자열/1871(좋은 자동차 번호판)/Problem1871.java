import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem1871 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        bw.write(new Solver(n, arr).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private int n;
        private String[] numberPlate;

        public Solver(int n, String[] numberPlate) {
            this.n = n;
            this.numberPlate = numberPlate;
        }

        public String solve() {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < n; i++) {
                String firstPart = numberPlate[i].substring(0, 3);
                String secondPart = numberPlate[i].substring(4);

                sb.append(
                        (Math.abs(getFirstValue(firstPart) - getSecondValue(secondPart)) <= 100) ? "nice" : "not nice")
                        .append("\n");
            }

            return sb.toString();
        }

        private int getFirstValue(String firstPart) {
            int value = 0;

            for (int i = 2; i >= 0; i--) {
                value += ((int) firstPart.charAt(i) - 65) * Math.pow(26, 2 - i);
            }

            return value;
        }

        private int getSecondValue(String secondPart) {
            return Integer.parseInt(secondPart);
        }
    }
}
