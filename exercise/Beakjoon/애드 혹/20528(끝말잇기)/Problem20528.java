import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem20528 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = st.nextToken();
        }

        bw.write(new Solver(n, arr).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private int n;
        private String[] palindromes;

        public Solver(int n, String[] palindromes) {
            this.n = n;
            this.palindromes = palindromes;
        }

        public String solve() {
            char c = ' ';
            for(int i = 0; i < n; i++) {
                String palindrome = palindromes[i];

                if(c == ' ') {
                    c = palindrome.charAt(0);
                } else {
                    if (c != palindrome.charAt(0)) {
                        return "0";
                    }
                }
            }

            return "1";
        }
    }
}
