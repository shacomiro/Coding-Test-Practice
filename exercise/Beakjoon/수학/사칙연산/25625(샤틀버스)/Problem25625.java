import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem25625 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        bw.write(new Solver(x, y).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private int x, y;

        public Solver(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public String solve() {
            return String.valueOf((x <= y) ? y - x : x + y);
        }
    }
}
