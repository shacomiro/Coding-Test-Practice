import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem9654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(new Solver().solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        public String solve() {
            return new StringBuilder()
                    .append("SHIP NAME      CLASS          DEPLOYMENT IN SERVICE").append("\n")
                    .append("N2 Bomber      Heavy Fighter  Limited    21        ").append("\n")
                    .append("J-Type 327     Light Combat   Unlimited  1         ").append("\n")
                    .append("NX Cruiser     Medium Fighter Limited    18        ").append("\n")
                    .append("N1 Starfighter Medium Fighter Unlimited  25        ").append("\n")
                    .append("Royal Cruiser  Light Combat   Limited    4         ").toString();
        }
    }
}
