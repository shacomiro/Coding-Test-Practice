import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

class Solution4358 {
    private double n;
    private SortedMap<String, Integer> treeCounts;

    public Solution4358(List<String> treeList) {
        this.n = 0;
        this.treeCounts = new TreeMap<>();
        for(String treeName : treeList) {
            treeCounts.put(treeName, treeCounts.getOrDefault(treeName, 0) + 1);
            n++;
        }
    }

    public String solve() {
        StringBuilder sb = new StringBuilder();

        for(Map.Entry<String,Integer> tree : treeCounts.entrySet()) {
            sb.append(tree.getKey())
                .append(" ")
                .append(String.format("%.4f", tree.getValue() / n * 100.0))
                .append("\n");
        }

        return sb.toString();
    }
}

public class Problem4358 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<String> list = new ArrayList<>(10000);
        String input;
        while((input = br.readLine()) != null) {
            list.add(input);
        }

        bw.write(new Solution4358(list).solve());
        bw.flush();
        bw.close();
    }
}
