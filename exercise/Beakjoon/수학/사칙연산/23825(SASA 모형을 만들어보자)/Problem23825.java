import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem23825 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        bw.write(new Solver(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private int s;
        private int a;

        public Solver(int s, int a) {
            this.s = s;
            this.a = a;
        }

        public String solve() {
            return String.valueOf(Math.min(s / 2, a / 2));
        }
    }
}
