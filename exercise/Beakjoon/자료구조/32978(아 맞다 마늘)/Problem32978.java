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

class Solution32978 {
    private int n;
    private List<String> plan;
    private Set<String> actualSet;

    public Solution32978(int n, List<String> plan, List<String> actual) {
        this.n = n;
        this.plan = plan;
        this.actualSet = new HashSet<>(actual);
    }

    public String solve() {
        int idx = -1;

        for (int i = 0; i < n; i++) {
            if (!actualSet.contains(plan.get(i))) {
                idx = i;
                break;
            }
        }

        return plan.get(idx);
    }
}

public class Problem32978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        List<String> list1 = new ArrayList<>(n);
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list1.add(st.nextToken());
        }
        List<String> list2 = new ArrayList<>(n - 1);
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n - 1; i++) {
            list2.add(st.nextToken());
        }

        bw.write(new Solution32978(n, list1, list2).solve());
        bw.flush();
        bw.close();
    }
}
