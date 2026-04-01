import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem31775 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(new Solver(br.readLine(), br.readLine(), br.readLine()).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private String s1;
        private String s2;
        private String s3;
        private boolean l;
        private boolean k;
        private boolean p;

        public Solver(String s1, String s2, String s3) {
            this.s1 = s1;
            this.s2 = s2;
            this.s3 = s3;
            this.l = false;
            this.k = false;
            this.p = false;
        }

        public String solve() {
            check(s1);
            check(s2);
            check(s3);

            return (l && k && p) ? "GLOBAL" : "PONIX";
        }

        private void check(String s) {
            if (s.charAt(0) == 'l') {
                l = true;
            } else if (s.charAt(0) == 'k') {
                k = true;
            } else if (s.charAt(0) == 'p') {
                p = true;
            }
        }
    }
}
