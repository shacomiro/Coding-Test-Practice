import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.time.LocalDate;

public class Problem10768 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(new Solver(Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine())).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private int month;
        private int day;

        public Solver(int month, int day) {
            this.month = month;
            this.day = day;
        }

        public String solve() {
            LocalDate specialDay = LocalDate.of(2015, 2, 18);
            LocalDate userDay = LocalDate.of(2015, month, day);

            return (userDay.isBefore(specialDay)) ? "Before" : ((userDay.isAfter(specialDay)) ? "After" : "Special");
        }
    }
}