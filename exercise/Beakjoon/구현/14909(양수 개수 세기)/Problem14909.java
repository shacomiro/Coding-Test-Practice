import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem14909 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>(st.countTokens());
        while (st.hasMoreTokens()) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        bw.write(new Solver(list).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private List<Integer> numbers;

        public Solver(List<Integer> numbers) {
            this.numbers = numbers;
        }

        public String solve() {
            int count = 0;

            for (int n : numbers) {
                if (n > 0) {
                    count++;
                }
            }

            return String.valueOf(count);
        }
    }
}
