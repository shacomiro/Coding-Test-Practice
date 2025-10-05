import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Problem4806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input;
        List<String> list = new ArrayList<>();

        while ((input = br.readLine()) != null) {
            list.add(input);
        }

        bw.write(new Solver(list).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private List<String> lines;

        public Solver(List<String> lines) {
            this.lines = lines;
        }

        public String solve() {
            return String.valueOf(lines.size());
        }
    }
}
