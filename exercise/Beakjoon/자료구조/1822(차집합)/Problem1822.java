import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

class Solution1822 {
    private Set<Integer> a;
    private List<Integer> b;

    public Solution1822(List<Integer> a, List<Integer> b) {
        this.a = new TreeSet<>(a);
        this.b = b;
    }

    public String solve() {
        for(int i : b) {
            if(a.contains(i)) {
                a.remove(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(a.size()).append("\n");
        for(int i : a) {
            sb.append(i).append(" ");
        }

        return sb.toString();
    }
}

public class Problem1822 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int na = Integer.parseInt(st.nextToken());
        int nb = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        List<Integer> list1 = new ArrayList<>(na);
        for(int i = 0; i < na; i++) {
            list1.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        List<Integer> list2 = new ArrayList<>(na);
        for(int i = 0; i < nb; i++) {
            list2.add(Integer.parseInt(st.nextToken()));
        }

        bw.write(new Solution1822(list1, list2).solve());
        bw.flush();
        bw.close();
    }
}
