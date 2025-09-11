import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem3028 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(new Solver(br.readLine()).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private boolean[] cups;
        private String order;

        public Solver(String order) {
            this.cups = new boolean[] { true, false, false };
            this.order = order;
        }

        public String solve() {
            for (char c : order.toCharArray()) {
                switch (c) {
                    case 'A':
                        swap(0, 1);
                        break;
                    case 'B':
                        swap(1, 2);
                        break;
                    case 'C':
                        swap(0, 2);
                        break;
                }
            }

            int position = 0;
            for (int i = 0; i < 3; i++) {
                if (cups[i]) {
                    position = i + 1;
                    break;
                }
            }

            return String.valueOf(position);
        }

        private void swap(int from, int to) {
            boolean temp = cups[from];
            cups[from] = cups[to];
            cups[to] = temp;
        }
    }
}
