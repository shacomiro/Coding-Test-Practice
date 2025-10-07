import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem4999 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(new Solver(br.readLine(), br.readLine()).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private String jeahwan;
        private String doctor;

        public Solver(String jeahwan, String doctor) {
            this.jeahwan = jeahwan;
            this.doctor = doctor;
        }

        public String solve() {
            return (jeahwan.length() >= doctor.length()) ? "go" : "no";
        }
    }
}