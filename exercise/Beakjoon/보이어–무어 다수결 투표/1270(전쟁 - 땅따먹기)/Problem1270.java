import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

class Solution1270 {
    private int n;
    private List<List<Long>> battleFields;

    public Solution1270(int n, List<List<Long>> battleFields) {
        this.n = n;
        this.battleFields = battleFields;
    }

    public String solve() {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++) {
            long winningArmy = 0;
            int count = 0;
            Map<Long, Integer> armies = new HashMap<>();

            for(long army : battleFields.get(i)) {
                if(count == 0) {
                    winningArmy = army;
                }
                count += (winningArmy == army) ? 1 : -1;

                armies.put(army, armies.getOrDefault(army, 0) + 1);
            }

            sb.append((armies.get(winningArmy) > battleFields.get(i).size() / 2) ? winningArmy : "SYJKGW")
                .append("\n");
        }

        return sb.toString();
    }
}

public class Problem1270 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        List<List<Long>> list1 = new ArrayList<>(n);
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            List<Long> list2 = new ArrayList<>(Integer.parseInt(st.nextToken()));
            while(st.hasMoreTokens()) {
                list2.add(Long.parseLong(st.nextToken()));
            }

            list1.add(list2);
        }

        bw.write(new Solution1270(n, list1).solve());
        bw.flush();
        bw.close();
    }
}
