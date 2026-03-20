import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem30676 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(new Solver(Integer.parseInt(br.readLine())).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private int lambda;

        public Solver(int lambda) {
            this.lambda = lambda;
        }

        public String solve() {
            String color = "";

            if (620 <= lambda && lambda <= 780) {
                color = "Red";
            } else if (590 <= lambda && lambda < 620) {
                color = "Orange";
            } else if (570 <= lambda && lambda < 590) {
                color = "Yellow";
            } else if (495 <= lambda && lambda < 570) {
                color = "Green";
            } else if (450 <= lambda && lambda < 495) {
                color = "Blue";
            } else if (425 <= lambda && lambda < 450) {
                color = "Indigo";
            } else if (380 <= lambda && lambda < 425) {
                color = "Violet";
            }

            return color;
        }
    }
}
