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

class Solution26069 {
    Set<String> dance;
    List<String[]> met;

    public Solution26069(List<String[]> met) {
        this.dance = new HashSet<>();
        this.met = met;
    }

    public String solve() {
        dance.add("ChongChong");

        for(String[] m : met) {
            if(dance.contains(m[0]) || dance.contains(m[1])) {
                dance.add(m[0]);
                dance.add(m[1]);
            }
        }

        return String.valueOf(dance.size());
    }
}

public class Problem26069 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        List<String[]> list = new ArrayList<>(n);
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new String[] {st.nextToken(), st.nextToken()});
        }

        bw.write(new Solution26069(list).solve());
        bw.flush();
        bw.close();
    }
}
