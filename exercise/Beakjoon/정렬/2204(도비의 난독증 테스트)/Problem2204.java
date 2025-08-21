import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class Problem2204 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input;

        while (!(input = br.readLine()).equals("0")) {
            int n = Integer.parseInt(input);
            String[] arr = new String[n];
            for (int i = 0; i < n; i++) {
                arr[i] = br.readLine();
            }

            bw.write(new Solver(arr).solve());
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }

    static class Solver {
        private String[] words;

        public Solver(String[] words) {
            this.words = words;
        }

        public String solve() {
            Arrays.sort(words, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.compareToIgnoreCase(o2);
                }
            });

            return String.valueOf(words[0]);
        }
    }
}
