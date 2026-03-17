import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem30402 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        char[][] arr = new char[15][15];
        
        for (int i = 0; i < 15; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 15; j++) {
                arr[i][j] = st.nextToken().charAt(0);
            }
        }

        bw.write(new Solver(arr).solve());
        bw.flush();
        bw.close();
        br.close();
    }

    static class Solver {
        private char[][] pixels;
        
        public Solver(char[][] pixels) {
            this.pixels = pixels;
        }

        public String solve() {
            for (int i = 0; i < 15; i++) {
                for (int j = 0; j < 15; j++) {
                    if (pixels[i][j] == 'w') return "chunbae";
                    if (pixels[i][j] == 'b') return "nabi";
                    if (pixels[i][j] == 'g') return "yeongcheol";
                }
            }

            return ""; 
        }
    }
}
