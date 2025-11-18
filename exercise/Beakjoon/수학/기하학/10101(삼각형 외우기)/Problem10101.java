import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem10101 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(new Solver(Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine()),
                Integer.parseInt(br.readLine())).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private int angle1;
        private int angle2;
        private int angle3;

        public Solver(int angle1, int angle2, int angle3) {
            this.angle1 = angle1;
            this.angle2 = angle2;
            this.angle3 = angle3;
        }

        public String solve() {
            if (angle1 + angle2 + angle3 == 180) {
                if (angle1 == 60 && angle2 == 60 && angle3 == 60) {
                    return "Equilateral";
                } else if (angle1 == angle2 || angle1 == angle3 || angle2 == angle3) {
                    return "Isosceles";
                } else {
                    return "Scalene";
                }
            } else {
                return "Error";
            }
        }
    }
}