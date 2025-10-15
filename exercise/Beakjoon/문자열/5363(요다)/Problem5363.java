import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem5363 {
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
        private String[] sentences;

        public Solver(int n, String[] sentences) {
            this.n = n;
            this.sentences = sentences;
        }

        public String solve() {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < n; i++) {
                String[] temp = sentences[i].split(" ");

                for (int j = 2; j < temp.length; j++) {
                    sb.append(temp[j]).append(" ");
                }
                sb.append(temp[0]).append(" ").append(temp[1]).append("\n");
            }

            return sb.toString();
        }
    }
}
