import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Problem23795 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input;

        List<Integer> list = new ArrayList<>();
        while (!(input = br.readLine()).equals("-1")) {
            list.add(Integer.parseInt(input));
        }

        bw.write(new Solver(list).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        List<Integer> money;

        public Solver(List<Integer> money) {
            this.money = money;
        }

        public String solve() {
            return String.valueOf(money.stream().collect(Collectors.summingInt(Integer::intValue)));
        }
    }
}
