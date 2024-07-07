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

class Solution2776 {
    Set<Integer> note1;
    List<Integer> note2;

    public Solution2776(List<Integer> note1, List<Integer> note2) {
        this.note1 = new HashSet<>(note1);
        this.note2 = note2;
    }

    public String solve() {
        StringBuilder sb = new StringBuilder();

        for(int number : note2) {
            if(note1.contains(number)) {
                sb.append(1);
            } else {
                sb.append(0);
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}

public class Problem2776 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            List<Integer> list1 = new ArrayList<>(n);
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                list1.add(Integer.parseInt(st.nextToken()));
            }
            int m = Integer.parseInt(br.readLine());
            List<Integer> list2 = new ArrayList<>(m);
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                list2.add(Integer.parseInt(st.nextToken()));
            }

            bw.write(new Solution2776(list1, list2).solve());
        }
        bw.flush();
        bw.close();
    }
}
