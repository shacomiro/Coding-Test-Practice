import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem15814 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        String s = br.readLine();
        int t = Integer.parseInt(br.readLine());
        int[][] arr = new int[t][2];
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        bw.write(new Solver(s, t, arr).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private String s;
        private int t;
        private int[][] ab;

        public Solver(String s, int t, int[][] ab) {
            this.s = s;
            this.t = t;
            this.ab = ab;
        }

        public String solve() {
            StringBuilder sb = new StringBuilder(s);

            for (int i = 0; i < t; i++) {
                int a = ab[i][0];
                int b = ab[i][1];

                char temp = sb.charAt(a);
                sb.setCharAt(a, sb.charAt(b));
                sb.setCharAt(b, temp);
            }

            return sb.toString();
        }
    }
}
