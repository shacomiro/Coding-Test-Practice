import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem2985 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        bw.write(new Solver(a, b, c).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private int a;
        private int b;
        private int c;

        public Solver(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        public String solve() {
            String op1 = "";
            String op2 = "";

            if (a + b == c) {
                op1 = "+";
                op2 = "=";
            } else if (a - b == c) {
                op1 = "-";
                op2 = "=";
            } else if (a * b == c) {
                op1 = "*";
                op2 = "=";
            } else if (a / b == c) {
                op1 = "/";
                op2 = "=";
            } else if (a == b + c) {
                op1 = "=";
                op2 = "+";
            } else if (a == b - c) {
                op1 = "=";
                op2 = "-";
            } else if (a == b * c) {
                op1 = "=";
                op2 = "*";
            } else if (a == b / c) {
                op1 = "=";
                op2 = "/";
            }

            return a + op1 + b + op2 + c;
        }
    }
}
