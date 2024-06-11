import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.Map.Entry;

class Solution2910 {
    private Map<Integer, Integer> numberFrequency;

    public Solution2910(List<Integer> list) {
        this.numberFrequency = new LinkedHashMap<>();

        for(int number : list) {
            numberFrequency.put(number, numberFrequency.getOrDefault(number, 0) + 1);
        }
    }

    public String solve() {
        List<Entry<Integer, Integer>> entries = new ArrayList<>(numberFrequency.entrySet());
        entries.sort(new Comparator<Entry<Integer, Integer>>() {
            @Override
            public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        StringBuilder sb = new StringBuilder();
        for(Entry<Integer, Integer> entry : entries) {
            for(int i = 0; i < entry.getValue(); i++) {
                sb.append(entry.getKey()).append(" ");
            }
        }

        return sb.toString();
    }
}

public class Problem2910 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st1.nextToken());
        int c = Integer.parseInt(st1.nextToken());
        List<Integer> list = new ArrayList<>(n);
        for(int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st2.nextToken()));
        }

        bw.write(new Solution2910(list).solve());
        bw.flush();
        bw.close();
    }
}