import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem11098 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int p = Integer.parseInt(br.readLine());
            int[] arr1 = new int[p];
            String[] arr2 = new String[p];
            for (int j = 0; j < p; j++) {
                st = new StringTokenizer(br.readLine());
                arr1[j] = Integer.parseInt(st.nextToken());
                arr2[j] = st.nextToken();
            }
            bw.write(new Solver(p, arr1, arr2).solve());
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }

    static class Solver {
        private int p;
        private int[] marketValues;
        private String[] names;

        public Solver(int p, int[] marketValues, String[] names) {
            this.p = p;
            this.marketValues = marketValues;
            this.names = names;
        }

        public String solve() {
            int maxMarketValue = 0;
            String name = "";

            for(int i = 0; i < p; i++) {
                if(marketValues[i] > maxMarketValue) {
                    maxMarketValue = marketValues[i];
                    name = names[i];
                }
            }

            return String.valueOf(name);
        }
    }
}
