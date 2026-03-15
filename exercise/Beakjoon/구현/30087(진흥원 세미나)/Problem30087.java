import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem30087 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        bw.write(new Solver(n, arr).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private int n;
        private String[] s;

        public Solver(int n, String[] s) {
            this.n = n;
            this.s = s;
        }

        public String solve() {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < n; i++) {
                switch (s[i]) {
                    case "Algorithm":
                        sb.append("204");
                        break;
                    case "DataAnalysis":
                        sb.append("207");
                        break;
                    case "ArtificialIntelligence":
                        sb.append("302");
                        break;
                    case "CyberSecurity":
                        sb.append("B101");
                        break;
                    case "Network":
                        sb.append("303");
                        break;
                    case "Startup":
                        sb.append("501");
                        break;
                    case "TestStrategy":
                        sb.append("105");
                        break;
                }
                sb.append("\n");
            }

            return sb.toString().trim();
        }
    }
}
