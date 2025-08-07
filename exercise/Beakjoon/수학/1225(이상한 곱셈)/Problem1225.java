import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem1225 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        bw.write(new Solver(st.nextToken(), st.nextToken()).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private String a;
        private String b;

        public Solver(String a, String b) {
            this.a = a;
            this.b = b;
        }

        public String solve() {
            long sum = 0;

            for (int i = 0; i < a.length(); i++) {
                for (int j = 0; j < b.length(); j++) {
                    sum += Character.getNumericValue(a.charAt(i)) * Character.getNumericValue(b.charAt(j));
                }
            }

            return String.valueOf(sum);
        }
    }
}
