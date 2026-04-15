import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem28444 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int i = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        bw.write(new Solver(h, i, a, r, c).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private int h, i, a, r, c;

        public Solver(int h, int i, int a, int r, int c) {
            this.h = h;
            this.i = i;
            this.a = a;
            this.r = r;
            this.c = c;
        }

        public String solve() {
            return String.valueOf((h * i) - (a * r * c));
        }
    }
}
