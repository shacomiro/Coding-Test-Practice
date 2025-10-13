import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Problem5337 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(new Solver().solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        public String solve() {
            return """
                    .  .   .
                    |  | _ | _. _ ._ _  _
                    |/\\|(/.|(_.(_)[ | )(/.
                    """;
        }
    }
}
