import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem17256 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int ax = Integer.parseInt(st.nextToken());
        int ay = Integer.parseInt(st.nextToken());
        int az = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int cx = Integer.parseInt(st.nextToken());
        int cy = Integer.parseInt(st.nextToken());
        int cz = Integer.parseInt(st.nextToken());

        bw.write(new Solver(ax, ay, az, cx, cy, cz).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private int ax, ay, az;
        private int cx, cy, cz;

        public Solver(int ax, int ay, int az, int cx, int cy, int cz) {
            this.ax = ax;
            this.ay = ay;
            this.az = az;
            this.cx = cx;
            this.cy = cy;
            this.cz = cz;
        }

        public String solve() {
            return (cx - az) + " " + (cy / ay) + " " + (cz - ax);
        }
    }
}
