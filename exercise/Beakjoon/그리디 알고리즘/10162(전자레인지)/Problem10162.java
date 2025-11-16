import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem10162 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(new Solver(Integer.parseInt(br.readLine())).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private static final int A = 300;
        private static final int B = 60;
        private static final int C = 10;
        private int time;

        public Solver(int time) {
            this.time = time;
        }

        public String solve() {
            int aCnt = 0;
            int bCnt = 0;
            int cCnt = 0;

            aCnt += time / A;
            time %= A;

            bCnt += time / B;
            time %= B;

            cCnt += time / C;
            time %= C;

            return (time > 0) ? "-1" : aCnt + " " + bCnt + " " + cCnt;
        }
    }
}
