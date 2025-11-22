import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem10205 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            bw.write(new Solver(i, Integer.parseInt(br.readLine()), br.readLine()).solve());
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    static class Solver {
        private int i;
        private int h;
        private String actions;

        public Solver(int i, int h, String actions) {
            this.i = i;
            this.h = h;
            this.actions = actions;
        }

        public String solve() {
            for (int i = 0; i < actions.length(); i++) {
                char action = actions.charAt(i);

                switch (action) {
                    case 'c':
                        h += 1;
                        break;
                    case 'b':
                        h -= 1;
                        break;
                }
            }

            return "Data Set " + (i + 1) + ":\n" + h + "\n";
        }
    }
}
