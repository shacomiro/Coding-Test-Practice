import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem30958 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();

        bw.write(new Solver(n, s).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private int[] counts;
        private int n;
        private String logoSong;

        public Solver(int n, String logoSong) {
            this.counts = new int[26];
            this.n = n;
            this.logoSong = logoSong;
        }

        public String solve() {
            for (int i = 0; i < n; i++) {
                if (logoSong.charAt(i) < 'a' || logoSong.charAt(i) > 'z') {
                    continue;
                }

                counts[logoSong.charAt(i) - 'a']++;
            }

            int max = 0;
            for (int count : counts) {
                max = Math.max(max, count);
            }

            return String.valueOf(max);
        }
    }
}
