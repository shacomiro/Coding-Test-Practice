import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem30794 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int lv = Integer.parseInt(st.nextToken());
        String jdg = st.nextToken();

        bw.write(new Solver(lv, jdg).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private int lv;
        private String jdg;

        public Solver(int lv, String jdg) {
            this.lv = lv;
            this.jdg = jdg;
        }

        public String solve() {
            int point = 0;

            switch (jdg) {
                case "miss":
                    break;
                case "bad":
                    point = 200 * lv;
                    break;
                case "cool":
                    point = 400 * lv;
                    break;
                case "great":
                    point = 600 * lv;
                    break;
                case "perfect":
                    point = 1000 * lv;
                    break;
            }

            return String.valueOf(point);
        }
    }
}
