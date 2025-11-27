import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem10824 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        bw.write(new Solver(st.nextToken(), st.nextToken(), st.nextToken(), st.nextToken()).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private String a, b, c, d;

        public Solver(String a, String b, String c, String d) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
        }

        public String solve() {
            return String.valueOf(Long.parseLong(new StringBuilder().append(a).append(b).toString())
                    + Long.parseLong(new StringBuilder().append(c).append(d).toString()));
        }
    }
}
