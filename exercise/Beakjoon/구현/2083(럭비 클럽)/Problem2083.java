import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem2083 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        String input;

        while (!(input = br.readLine()).equals("# 0 0")) {
            st = new StringTokenizer(input);

            bw.write(new Solver(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()))
                    .solve());
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    static class Solver {
        private String name;
        private int age;
        private int weight;

        public Solver(String name, int age, int weight) {
            this.name = name;
            this.age = age;
            this.weight = weight;
        }

        public String solve() {
            return (age > 17 || weight >= 80) ? (name + " Senior") : (name + " Junior");
        }
    }
}
