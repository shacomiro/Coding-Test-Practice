import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem31009 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        String[] arr1 = new String[n];
        int[] arr2 = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr1[i] = st.nextToken();
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(new Solver(n, arr1, arr2).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private int n;
        private String[] destinations;
        private int[] costs;

        public Solver(int n, String[] destinations, int[] costs) {
            this.n = n;
            this.destinations = destinations;
            this.costs = costs;
        }

        public String solve() {
            int costToJinju = 0;
            int countOverJunju = 0;

            for (int i = 0; i < n; i++) {
                if (destinations[i].equals("jinju")) {
                    costToJinju = costs[i];
                }
            }

            for (int i = 0; i < n; i++) {
                if (costs[i] > costToJinju) {
                    countOverJunju++;
                }
            }

            return costToJinju + "\n" + countOverJunju;
        }
    }
}
