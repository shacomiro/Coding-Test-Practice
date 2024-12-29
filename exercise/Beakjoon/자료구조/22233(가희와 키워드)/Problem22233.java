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

class Solution22233 {
    private Set<String> keywords;
    private List<List<String>> notes;

    public Solution22233(List<String> keywords, List<List<String>> notes) {
        this.keywords = new HashSet<>(keywords);
        this.notes = notes;
    }

    public String solve() {
        StringBuilder sb = new StringBuilder();

        for(List<String> note : notes) {
            for(String word : note) {
                if(keywords.contains(word)) {
                    keywords.remove(word);
                }
            }
            
            sb.append(keywords.size()).append("\n");
        }

        return sb.toString();
    }
}

public class Problem22233 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<String> list1 = new ArrayList<>(n);
        for(int i = 0; i < n; i++) {
            list1.add(br.readLine());
        }
        List<List<String>> list2 = new ArrayList<>(m);
        for(int i = 0; i < m; i++) {
            List<String> list3 = new ArrayList<>();
            st = new StringTokenizer(br.readLine(), ",");
            while(st.hasMoreTokens()) {
                list3.add(st.nextToken());
            }
            list2.add(list3);
        }

        bw.write(new Solution22233(list1, list2).solve());
        bw.flush();
        bw.close();
    }
}