import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution10546 {
    private List<String> participants;
    private List<String> finishers;
    private Map<String, Integer> map;

    public Solution10546(List<String> participants, List<String> finishers) {
        this.participants = participants;
        this.finishers = finishers;
        this.map = new HashMap<>(participants.size());
    }

    public String solve() {
        for(String p : participants) {
            map.put(p, map.getOrDefault(p, 0) + 1);
        }
        for(String f : finishers) {
            map.compute(f, (k, v) -> v == 1 ? null : v - 1);
        }

        return map.keySet().iterator().next();
    }
}

public class Problem10546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        List<String> list1 = new ArrayList<>(n);
        for(int i = 0; i < n; i++) {
            list1.add(br.readLine());
        }
        List<String> list2 = new ArrayList<>(n - 1);
        for(int i = 0; i < n - 1; i++) {
            list2.add(br.readLine());
        }

        bw.write(new Solution10546(list1, list2).solve());
        bw.flush();
        bw.close();
    }
}
