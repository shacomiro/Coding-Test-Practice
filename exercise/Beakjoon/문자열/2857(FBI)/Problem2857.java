import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem2857 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] arr = new String[5];
        for (int i = 0; i < 5; i++) {
            arr[i] = br.readLine();
        }

        bw.write(new Solver(arr).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private String[] names;

        public Solver(String[] names) {
            this.names = names;
        }

        public String solve() {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < 5; i++) {
                if (names[i].contains("FBI")) {
                    sb.append(i + 1).append(" ");
                }
            }

            return (sb.length() == 0) ? "HE GOT AWAY!" : sb.toString().trim();
        }
    }
}
