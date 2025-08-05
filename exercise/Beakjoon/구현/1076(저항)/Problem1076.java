import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.List;

public class Problem1076 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(new Solver(br.readLine(), br.readLine(), br.readLine()).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private static final List<String> COLORS = Arrays.asList(new String[] {
                "black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"
        });
        private String first;
        private String second;
        private String third;

        public Solver(String first, String second, String third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }

        public String solve() {
            int value1 = COLORS.indexOf(first);
            int value2 = COLORS.indexOf(second);
            long multiplier = (long) Math.pow(10, COLORS.indexOf(third));

            return String.valueOf((value1 * 10 + value2) * multiplier);
        }
    }
}
