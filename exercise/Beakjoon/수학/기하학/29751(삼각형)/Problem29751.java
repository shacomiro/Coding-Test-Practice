import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem29751 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        bw.write(new Solver(w, h).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private int width;
        private int height;

        public Solver(int width, int heiht) {
            this.width = width;
            this.height = heiht;
        }

        public String solve() {
            return String.format("%.1f", width * height / 2.0);
        }
    }
}
