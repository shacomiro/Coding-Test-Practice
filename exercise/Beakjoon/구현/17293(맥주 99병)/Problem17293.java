import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem17293 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(new Solver(Integer.parseInt(br.readLine())).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private int n;

        public Solver(int n) {
            this.n = n;
        }

        public String solve() {
            StringBuilder sb = new StringBuilder();
            int left = n;

            while (left >= 0) {
                if (left > 1) {
                    sb.append(left).append(" bottles of beer on the wall, ").append(left).append(" bottles of beer.\n")
                            .append("Take one down and pass it around, ").append(left - 1)
                            .append((left - 1 == 1) ? " bottle" : " bottles").append(" of beer on the wall.\n");
                } else if (left == 1) {
                    sb.append(left).append(" bottle of beer on the wall, ").append(left).append(" bottle of beer.\n")
                            .append("Take one down and pass it around, no more bottles of beer on the wall.\n");
                } else {
                    sb.append("No more bottles of beer on the wall, no more bottles of beer.\n")
                            .append("Go to the store and buy some more, ").append(n)
                            .append((n == 1) ? " bottle" : " bottles").append(" of beer on the wall.\n");
                }
                sb.append("\n");

                left--;
            }

            return sb.toString();
        }
    }
}