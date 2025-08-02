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

public class Problem1269 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        List<Integer> list1 = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list1.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        List<Integer> list2 = new ArrayList<>(m);
        for (int i = 0; i < m; i++) {
            list2.add(Integer.parseInt(st.nextToken()));
        }

        bw.write(new Solver(list1, list2).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private Set<Integer> a;
        private Set<Integer> b;

        public Solver(List<Integer> a, List<Integer> b) {
            this.a = new HashSet<>(a);
            this.b = new HashSet<>(b);
        }

        public String solve() {
            int intersectionCount = 0;
            Set<Integer> big = (a.size() > b.size()) ? a : b;
            Set<Integer> small = (a.size() <= b.size()) ? a : b;

            for (int s : small) {
                if (big.contains(s)) {
                    intersectionCount++;
                }
            }

            return String.valueOf(small.size() + big.size() - (2 * intersectionCount));
        }
    }
}
