import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution1302 {
    private String[] books;
    private Map<String, Integer> map;

    public Solution1302(String[] books) {
        this.books = books;
        this.map = new HashMap<>();
    }

    public String solve() {
        for(String book : books) {
            map.put(book, map.getOrDefault(book, 0) + 1);
        }

        List<String> rank = new ArrayList<>(map.keySet());
        Collections.sort(rank, (b1, b2) -> 
            (map.get(b1) == map.get(b2)) ? b1.compareTo(b2) : map.get(b2) - map.get(b1)
        );

        return String.valueOf(rank.get(0));
    }
}
public class Problem1302 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        for(int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        bw.write(new Solution1302(arr).solve());
        bw.flush();
        bw.close();
    }
}
