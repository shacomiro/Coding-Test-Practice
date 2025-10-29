import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Problem9653 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(new Solver().solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        public String solve() {
            return """
                        8888888888  888    88888
                       88     88   88 88   88  88
                        8888  88  88   88  88888
                           88 88 888888888 88   88
                    88888888  88 88     88 88    888888

                    88  88  88   888    88888    888888
                    88  88  88  88 88   88  88  88
                    88 8888 88 88   88  88888    8888
                     888  888 888888888 88  88      88
                      88  88  88     88 88   88888888
                                        """;
        }
    }
}
