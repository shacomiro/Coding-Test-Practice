import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem28290 {
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
            String type = "";

            switch (s) {
                case "fdsajkl;":
                    type = "in-out";
                    break;
                case "jkl;fdsa":
                    type = "in-out";
                    break;
                case "asdf;lkj":
                    type = "out-in";
                    break;
                case ";lkjasdf":
                    type = "out-in";
                    break;
                case "asdfjkl;":
                    type = "stairs";
                    break;
                case ";lkjfdsa":
                    type = "reverse";
                    break;
                default:
                    type = "molu";
                    break;
            }

            return type;
        }
    }
}