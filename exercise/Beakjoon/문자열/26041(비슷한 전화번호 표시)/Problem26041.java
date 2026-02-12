import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem26041 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        List<String> a = new ArrayList<>();
        while (st.hasMoreTokens()) {
            a.add(st.nextToken());
        }
        String b = br.readLine();

        bw.write(new Solver(a, b).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private List<String> a;
        private String b;

        public Solver(List<String> a, String b) {
            this.a = a;
            this.b = b;
        }

        public String solve() {
            int count = 0;

            for (String s : a) {
                if (!s.equals(b) && s.substring(0, Math.min(s.length(), b.length())).equals(b)) {
                    count++;
                }
            }

            return String.valueOf(count);
        }
    }
}
