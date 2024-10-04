import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.StringTokenizer;

class Solution25329 {
    private static final int BASIC_MINITES = 100;
    private static final int BASIC_RATE = 10;
    private static final int UNIT_MINUTES = 50;
    private static final int UNIT_RATE = 3;

    private List<String> callLogs;
    private Map<String, Integer> map;

    public Solution25329(List<String> callLogs) {
        this.callLogs = callLogs;
        this.map = new HashMap<>();
    }

    public String solve() {
        StringTokenizer st;

        for(String cl : callLogs) {
            st = new StringTokenizer(cl);
            String time = st.nextToken();
            String name = st.nextToken();
            st = new StringTokenizer(time, ":");
            int hour = Integer.parseInt(st.nextToken());
            int min = Integer.parseInt(st.nextToken());

            min += hour * 60;
            map.put(name, map.getOrDefault(name, 0) + min);
        }
        
        map.replaceAll((key, value) -> 
            BASIC_RATE + ((value <= BASIC_MINITES) ? 0 : (int) Math.ceil(((double) (value - BASIC_MINITES) / UNIT_MINUTES)) * UNIT_RATE)
        );

        List<String> names = new ArrayList<>(map.keySet());
        names.sort((n1, n2) ->
            (!Objects.equals(map.get(n1), map.get(n2))) ? Integer.compare(map.get(n2), map.get(n1)) : n1.compareTo(n2)
        );

        StringBuilder sb = new StringBuilder();
        for (String name : names) {
            sb.append(name).append(" ").append(map.get(name)).append("\n");
        }

        return sb.toString();
    }
}

public class Problem25329 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>(n);
        for(int i = 0; i < n; i++) {
            list.add(br.readLine());
        }

        bw.write(new Solution25329(list).solve());
        bw.flush();
        bw.close();
    }
}
