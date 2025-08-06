import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Map;
import java.util.TreeMap;

public class Problem1159 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        bw.write(new Solver(n, arr).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private int n;
        private String[] names;
        private Map<Character, Integer> map;

        public Solver(int n, String[] names) {
            this.n = n;
            this.names = names;
            this.map = new TreeMap<>();
        }

        public String solve() {
            for (int i = 0; i < n; i++) {
                map.put(names[i].charAt(0), map.getOrDefault(names[i].charAt(0), 0) + 1);
            }

            StringBuilder sb = new StringBuilder();
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                if (entry.getValue() >= 5) {
                    sb.append(entry.getKey());
                }
            }

            return (sb.length() == 0) ? "PREDAJA" : sb.toString();
        }
    }
}
