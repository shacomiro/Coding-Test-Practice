import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

class Solution14425 {
    private Set<String> set;
    private List<String> search;

    public Solution14425(List<String> strings, List<String> search) {
        this.set = new HashSet<>(strings);
        this.search = search;
    }

    public String solve() {
        int count = 0;

        for(String s : search) {
            if(set.contains(s)) {
                count++;
            }
        }
        
        return String.valueOf(count);
    }
}

public class Problem14425 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<String> list1 = new ArrayList<>(n);
        for(int i = 0; i < n; i++) {
            list1.add(br.readLine());
        }
        List<String> list2 = new ArrayList<>(n);
        for(int i = 0; i < m; i++) {
            list2.add(br.readLine());
        }

        bw.write(new Solution14425(list1, list2).solve());
        bw.flush();
        bw.close();
    }
}
