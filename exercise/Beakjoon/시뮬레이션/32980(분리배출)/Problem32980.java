import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Solution32980 {
    private final String[] type = { "P", "C", "V", "S", "G", "F", "O" };
    private int n;
    private String[] trash;
    private Map<String, Integer> cost;

    public Solution32980(int n, String[] trash, int[] r, int o) {
        this.n = n;
        this.trash = trash;
        this.cost = new HashMap<>();

        for (int i = 0; i < 6; i++) {
            cost.put(type[i], r[i]);
        }
        cost.put(type[6], o);
    }

    public String solve() {
        long totalCost = 0;

        for (int i = 0; i < n; i++) {
            int typeCnt = 0;
            int currSize = trash[i].length();
            String currType = "O";

            for (int j = 0; j < type.length && typeCnt <= 1; j++) {
                if (trash[i].contains(type[j])) {
                    typeCnt++;
                    currType = type[j];
                }
            }

            totalCost += ((typeCnt == 1) ? Math.min(cost.get("O"), cost.get(currType)) : cost.get("O")) * currSize;
        }

        return String.valueOf(totalCost);
    }
}

public class Problem32980 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] r = new int[6];
        for (int i = 0; i < 6; i++) {
            r[i] = Integer.parseInt(st.nextToken());
        }
        int o = Integer.parseInt(br.readLine());

        bw.write(new Solution32980(n, arr, r, o).solve());
        bw.flush();
        bw.close();
    }
}
