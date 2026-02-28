import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem28691 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(new Solver(br.readLine()).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private String s;

        public Solver(String s) {
            this.s = s;
        }

        public String solve() {
            String dongari = "";

            switch (s) {
                case "M":
                    dongari = "MatKor";
                    break;
                case "W":
                    dongari = "WiCys";
                    break;
                case "C":
                    dongari = "CyKor";
                    break;
                case "A":
                    dongari = "AlKor";
                    break;
                case "$":
                    dongari = "$clear";
                    break;
            }

            return String.valueOf(dongari);
        }
    }
}
