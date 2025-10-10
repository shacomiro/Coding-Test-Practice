import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem4998 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        String input;

        while ((input = br.readLine()) != null) {
            st = new StringTokenizer(input);
            double n = Double.parseDouble(st.nextToken());
            double b = Double.parseDouble(st.nextToken());
            double m = Double.parseDouble(st.nextToken());
            bw.write(new Solver(n, b, m).solve());
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    static class Solver {
        private double n;
        private double b;
        private double m;

        public Solver(double n, double b, double m) {
            this.n = n;
            this.b = b;
            this.m = m;
        }

        public String solve() {
            int year = 0;

            while (n < m) {
                n += n * b / 100;
                year++;
            }

            return String.valueOf(year);
        }
    }
}
