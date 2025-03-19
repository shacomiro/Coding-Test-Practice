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

class Solution9536 {
    private List<String> says;
    private Set<String> note;

    public Solution9536(List<String> says, List<String> note) {
        this.says = says;
        this.note = new HashSet<>(note);
    }

    public String solve() {
        StringBuilder sb = new StringBuilder();

        for(String s : says) {
            if(!note.contains(s)) {
                sb.append(s).append(" ");
            }
        }

        return sb.toString();
    }
}

public class Problem9536 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        String input;

        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            List<String> list1 = new ArrayList<>();
            while(st.hasMoreTokens()) {
                list1.add(st.nextToken());
            }
            List<String> list2 = new ArrayList<>(100);
            while(!(input = br.readLine()).equals("what does the fox say?")) {
                st = new StringTokenizer(input);
                st.nextToken();
                st.nextToken();
                String s = st.nextToken();
                list2.add(s);
            }
    
            bw.write(new Solution9536(list1, list2).solve());
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
