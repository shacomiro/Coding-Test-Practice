import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.Map.Entry;

class Solution20291 {
    private SortedMap<String, Integer> extentionMap;
    private List<String> files;

    public Solution20291(List<String> files) {
        this.extentionMap = new TreeMap<>();
        this.files = files;
    }

    public String solve() {
        for(String file : files) {
            String extention = file.split("\\.")[1];
            extentionMap.put(extention, extentionMap.getOrDefault(extention, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();
        for(Entry<String, Integer> extentionEntry : extentionMap.entrySet()) {
            sb.append(extentionEntry.getKey()).append(" ").append(extentionEntry.getValue()).append("\n");
        }

        return sb.toString();
    }
}

public class Problem20291 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>(n);
        for(int i = 0; i < n; i++) {
            list.add(br.readLine());
        }
        
        bw.write(new Solution20291(list).solve());
        bw.flush();
        bw.close();
    }
}
