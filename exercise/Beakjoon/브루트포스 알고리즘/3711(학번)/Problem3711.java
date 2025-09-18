import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class Problem3711 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int g = Integer.parseInt(br.readLine());
            int[] arr = new int[g];
            for (int j = 0; j < g; j++) {
                arr[j] = Integer.parseInt(br.readLine());
            }
            bw.write(new Solver(g, arr).solve());
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    static class Solver {
        private int g;
        private int[] ids;
        private Set<Integer> set;

        public Solver(int g, int[] ids) {
            this.g = g;
            this.ids = ids;
            this.set = new HashSet<>(g);
        }

        public String solve() {
            int m = 1;
            boolean found = false;

            while (!found) {
                for (int i = 0; i < g; i++) {
                    int newId = ids[i] % m;

                    if (set.contains(newId)) {
                        m++;
                        break;
                    }

                    set.add(newId);
                }

                if (set.size() == g) {
                    found = true;
                }
                set.clear();
            }

            return String.valueOf(m);
        }
    }
}
