import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Problem5533 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bw.write(new Solver(n, arr).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private int n;
        private int[][] cards;
        private Map<Integer, Integer> map;
        private int[] scores;

        public Solver(int n, int[][] cards) {
            this.n = n;
            this.cards = cards;
            this.map = new HashMap<>();
            this.scores = new int[n];
        }

        public String solve() {
            for (int game = 0; game < 3; game++) {
                for (int player = 0; player < n; player++) {
                    map.put(cards[player][game], map.getOrDefault(cards[player][game], 0) + 1);
                }

                for (int player = 0; player < n; player++) {
                    if (map.get(cards[player][game]) == 1) {
                        scores[player] += cards[player][game];
                    }
                }

                map.clear();
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb.append(scores[i]).append("\n");
            }

            return sb.toString();
        }
    }
}
