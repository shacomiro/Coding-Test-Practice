import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Problem4766 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input;
        List<Double> list = new ArrayList<>();

        while (!(input = br.readLine()).equals("999")) {
            list.add(Double.parseDouble(input));
        }
        bw.write(new Solver(list).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private List<Double> temperatures;

        public Solver(List<Double> temperatures) {
            this.temperatures = temperatures;
        }

        public String solve() {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < temperatures.size() - 1; i++) {
                sb.append(String.format("%.2f", temperatures.get(i + 1) - temperatures.get(i))).append("\n");
            }

            return sb.toString();
        }
    }
}
