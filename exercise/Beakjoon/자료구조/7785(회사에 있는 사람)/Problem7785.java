import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

class Solution7785 {
    private Set<String> remainSet;
    private List<String[]> log;
    
    public Solution7785(List<String[]> log) {
        this.remainSet = new TreeSet<>(Collections.reverseOrder());
        this.log = log;
    }

    public String solve() {
        for(String[] l : log) {
            if(l[1].equals("enter")) {
                remainSet.add(l[0]);
            } else {
                remainSet.remove(l[0]);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(String name : remainSet) {
            sb.append(name).append("\n");
        }

        return sb.toString();
    }
}

public class Problem7785 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        List<String[]> list = new ArrayList<>(n);
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(new String[] {st.nextToken(), st.nextToken()});
        }

        bw.write(new Solution7785(list).solve());
        bw.flush();
        bw.close();
    }
}
