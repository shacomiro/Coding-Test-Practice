import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem17388 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        bw.write(new Solver(s, k, h).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private int s, k, h;

        public Solver(int s, int k, int h) {
            this.s = s;
            this.k = k;
            this.h = h;
        }

        public String solve() {
            if (s + k + h >= 100) {
                return "OK";
            }
            int min = Math.min(s, Math.min(k, h));

            return (min == s) ? "Soongsil" : (min == k) ? "Korea" : "Hanyang";
        }
    }
}
