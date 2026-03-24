import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Problem30917 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(new Solver().solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private Scanner sc;
        private int a;
        private int b;

        public Solver() {
            this.sc = new Scanner(System.in);
            this.a = 0;
            this.b = 0;
        }

        public String solve() {
            for (int i = 1; i <= 9; i++) {
                System.out.println(q("?", "A", i));
                if (sc.nextInt() == 1) {
                    a = i;
                    break;
                }
            }

            for (int i = 1; i <= 9; i++) {
                System.out.println(q("?", "B", i));
                if (sc.nextInt() == 1) {
                    b = i;
                    break;
                }
            }

            return "! " + (a + b);
        }

        private String q(String type, String variable, int number) {
            return type + " " + variable + " " + number;
        }
    }
}
