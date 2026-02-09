import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.DecimalFormat;

public class Problem25905 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        double[] arr = new double[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = Double.parseDouble(br.readLine());
        }

        bw.write(new Solver(arr).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private double[] hammers;

        public Solver(double[] hammers) {
            this.hammers = hammers;
        }

        public String solve() {
            double minHammer = Double.MAX_VALUE;
            int minIdx = -1;
            double successRate = 1;

            for (int i = 0; i < 10; i++) {
                if (hammers[i] < minHammer) {
                    minHammer = hammers[i];
                    minIdx = i;
                }
            }

            for (int i = 0; i < 10; i++) {
                if (i == minIdx) {
                    continue;
                }
                successRate *= hammers[i];
            }

            for (int i = 9; i > 0; i--) {
                successRate /= i;
            }

            return new DecimalFormat("0.######").format(successRate * Math.pow(10, 9));
        }
    }
}
