import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem5656 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        String input;

        while (!(input = br.readLine()).contains("E")) {
            st = new StringTokenizer(input);
            bw.write(new Solver(Integer.parseInt(st.nextToken()), st.nextToken(), Integer.parseInt(st.nextToken()))
                    .solve());
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }

    static class Solver {
        private static int caseId = 1;
        private int a;
        private String op;
        private int b;

        public Solver(int a, String op, int b) {
            this.a = a;
            this.op = op;
            this.b = b;
        }

        public String solve() {
            boolean result = false;

            switch (op) {
                case ">":
                    result = (a > b) ? true : false;
                    break;
                case ">=":
                    result = (a >= b) ? true : false;
                    break;
                case "<":
                    result = (a < b) ? true : false;
                    break;
                case "<=":
                    result = (a <= b) ? true : false;
                    break;
                case "==":
                    result = (a == b) ? true : false;
                    break;
                case "!=":
                    result = (a != b) ? true : false;
                    break;
            }

            return "Case " + (caseId++) + ": " + result;
        }
    }
}
