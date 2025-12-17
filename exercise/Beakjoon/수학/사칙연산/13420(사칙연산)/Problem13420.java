import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem13420 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            bw.write(new Solver(br.readLine()).solve());
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    static class Solver {
        private String s;

        public Solver(String s) {
            this.s = s;
        }

        public String solve() {
            String[] splited = s.split(" ");
            long a = Long.parseLong(splited[0]);
            char op = splited[1].charAt(0);
            long b = Long.parseLong(splited[2]);
            long c = Long.parseLong(splited[4]);
            boolean isCorrect = false;

            switch (op) {
                case '+':
                    isCorrect = (a + b == c);
                    break;
                case '-':
                    isCorrect = (a - b == c);
                    break;
                case '*':
                    isCorrect = (a * b == c);
                    break;
                case '/':
                    isCorrect = (a / b == c);
                    break;
            }

            return isCorrect ? "correct" : "wrong answer";
        }
    }
}
