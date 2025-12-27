import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem15784 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bw.write(new Solver(n, a, b, arr).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private int n;
        private int a;
        private int b;
        private int[][] classRoom;

        public Solver(int n, int a, int b, int[][] classRoom) {
            this.n = n;
            this.a = a;
            this.b = b;
            this.classRoom = classRoom;
        }

        public String solve() {
            for (int i = 0; i < n; i++) {
                if (classRoom[a - 1][i] > classRoom[a - 1][b - 1]
                        || classRoom[i][b - 1] > classRoom[a - 1][b - 1]) {
                    return "ANGRY";
                }
            }

            return "HAPPY";
        }
    }
}
