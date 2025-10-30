import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Calendar;
import java.util.TimeZone;

public class Problem16170 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(new Solver().solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private Calendar cal;

        public Solver() {
            cal = Calendar.getInstance();
            cal.setTimeZone(TimeZone.getTimeZone("UTC"));
        }

        public String solve() {
            int year = cal.get(Calendar.YEAR);
            int month = cal.get(Calendar.MONTH) + 1;
            int day = cal.get(Calendar.DAY_OF_MONTH);

            return year + "\n" + month + "\n" + day;
        }
    }
}
