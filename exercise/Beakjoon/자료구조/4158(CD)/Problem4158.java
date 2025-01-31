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

class Solution4158 {
    private List<Integer> sgCD;
    private List<Integer> syCD;

    public Solution4158(List<Integer> sgCD, List<Integer> syCD) {
        this.sgCD = sgCD;
        this.syCD = syCD;
    }

    public String solve() {
        Set<Integer> cdSet = new HashSet<>(sgCD);
        int cnt = 0;

        for(int cd : syCD) {
            if(cdSet.contains(cd)) {
                cnt++;
            }
        }

        return String.valueOf(cnt);
    }
}
public class Problem4158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        String input;

        while(!(input = br.readLine()).equals("0 0")) {
            st = new StringTokenizer(input);
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            List<Integer> list1 = new ArrayList<>(n);
            for(int i = 0; i < n; i++) {
                list1.add(Integer.parseInt(br.readLine()));
            }
            List<Integer> list2 = new ArrayList<>(m);
            for(int i = 0; i < m; i++) {
                list2.add(Integer.parseInt(br.readLine()));
            }
    
            bw.write(new Solution4158(list1, list2).solve());
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
