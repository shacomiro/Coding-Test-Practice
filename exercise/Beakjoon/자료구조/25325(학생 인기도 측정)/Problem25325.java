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
import java.util.Map.Entry;

class Solution25325 {
    private int n;
    private List<String> students;
    private List<List<String>> favorites;
    private Map<String, Integer> popularityMap;

    public Solution25325(int n, List<String> students, List<List<String>> favorites) {
        this.n = n;
        this.students = students;
        this.favorites = favorites;
        this.popularityMap = new HashMap<>();
    }

    public String solve() {
        for (int i = 0; i < n; i++) {
            popularityMap.put(students.get(i), 0);
        }

        for (int i = 0; i < n; i++) {
            for (String fav : favorites.get(i)) {
                popularityMap.put(fav, popularityMap.get(fav) + 1);
            }
        }

        List<Entry<String, Integer>> sortedList = new ArrayList<>(popularityMap.entrySet());
        sortedList.sort((e1, e2) -> {
            int valueComparison = e2.getValue().compareTo(e1.getValue());

            return (valueComparison != 0) ? valueComparison : e1.getKey().compareTo(e2.getKey());
        });

        StringBuilder sb = new StringBuilder();
        for (Entry<String, Integer> entry : sortedList) {
            sb.append(entry.getKey()).append(" ").append(entry.getValue()).append("\n");
        }

        return sb.toString();
    }
}

public class Problem25325 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        List<String> list1 = new ArrayList<>(n);
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list1.add(st.nextToken());
        }
        List<List<String>> list2 = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<String> list3 = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                list3.add(st.nextToken());
            }
            list2.add(list3);
        }

        bw.write(new Solution25325(n, list1, list2).solve());
        bw.flush();
        bw.close();
    }
}
