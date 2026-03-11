import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem30032 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        bw.write(new Solver(n, d, arr).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private int n;
        private int d;
        private String[] alpabet;

        public Solver(int n, int d, String[] alphabet) {
            this.n = n;
            this.d = d;
            this.alpabet = alphabet;
        }

        public String solve() {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < alpabet[i].length(); j++) {
                    char c = alpabet[i].charAt(j);

                    if (d == 1) {
                        switch (c) {
                            case 'b':
                                sb.append('p');
                                break;
                            case 'd':
                                sb.append('q');
                                break;
                            case 'p':
                                sb.append('b');
                                break;
                            case 'q':
                                sb.append('d');
                                break;
                        }
                    } else {
                        switch (c) {
                            case 'b':
                                sb.append('d');
                                break;
                            case 'd':
                                sb.append('b');
                                break;
                            case 'p':
                                sb.append('q');
                                break;
                            case 'q':
                                sb.append('p');
                                break;
                        }
                    }
                }
                sb.append("\n");
            }

            return sb.toString();
        }
    }
}
