import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem28235 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(new Solver(br.readLine()).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        String s;

        public Solver(String s) {
            this.s = s;
        }

        public String solve() {
            String chant = "";

            switch (s) {
                case "SONGDO":
                    chant = "HIGHSCHOOL";
                    break;
                case "CODE":
                    chant = "MASTER";
                    break;
                case "2023":
                    chant = "0611";
                    break;
                case "ALGORITHM":
                    chant = "CONTEST";
                    break;
            }

            return chant;
        }
    }
}
