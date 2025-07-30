import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.Map.Entry;

public class Problem32953 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<List<String>> list1 = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            int k = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            List<String> list2 = new ArrayList<>(k);
            for (int j = 0; j < k; j++) {
                list2.add(st.nextToken());
            }
            list1.add(list2);
        }

        bw.write(new Solver(n, m, list1).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private int n;
        private int m;
        private List<List<String>> courseInfos;
        private Map<String, Integer> countMap;

        public Solver(int n, int m, List<List<String>> courseInfos) {
            this.n = n;
            this.m = m;
            this.courseInfos = courseInfos;
            this.countMap = new HashMap<>();
        }

        public String solve() {
            for (int i = 0; i < n; i++) {
                for (String studentId : courseInfos.get(i)) {
                    countMap.put(studentId, countMap.getOrDefault(studentId, 0) + 1);
                }
            }

            int count = 0;
            for (Entry<String, Integer> e : countMap.entrySet()) {
                if (e.getValue() >= m) {
                    count++;
                }
            }

            return String.valueOf(count);
        }
    }
}
