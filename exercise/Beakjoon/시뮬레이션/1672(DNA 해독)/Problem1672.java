import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem1672 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();

        bw.write(new Solver(n, str).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private static char[][] decode = {
                { 'A', 'C', 'A', 'G' },
                { 'C', 'G', 'T', 'A' },
                { 'A', 'T', 'C', 'G' },
                { 'G', 'A', 'G', 'T' }
        };
        private int n;
        private String encryptedDna;

        public Solver(int n, String encryptedDna) {
            this.n = n;
            this.encryptedDna = encryptedDna;
        }

        public String solve() {
            char decryptedDna = encryptedDna.charAt(n - 1);

            for (int i = n - 2; i >= 0; i--) {
                decryptedDna = decode[charToIndex(encryptedDna.charAt(i))][charToIndex(decryptedDna)];
            }

            return String.valueOf(decryptedDna);
        }

        private int charToIndex(char c) {
            if (c == 'A') {
                return 0;
            } else if (c == 'G') {
                return 1;
            } else if (c == 'C') {
                return 2;
            }
            return 3;
        }
    }
}
