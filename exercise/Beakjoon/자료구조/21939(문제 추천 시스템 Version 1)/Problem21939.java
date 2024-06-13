import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.SortedSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

class Solution21939 {
    private SortedSet<Problem> problemSet;
    private Map<Integer, Problem> problemMap;
    private String[] commands;

    public Solution21939(List<Problem> problems, String[] commands) {
        this.problemSet = new TreeSet<>();
        this.problemMap = new HashMap<>();
        this.commands = commands;

        for(Problem problem : problems) {
            problemSet.add(problem);
            problemMap.put(problem.getId(), problem);
        }
    }
    
    public String solve() {
        StringBuilder sb = new StringBuilder();
        int x, p, l;

        for(String command : commands) {
            StringTokenizer st = new StringTokenizer(command);
            String function = st.nextToken();
            
            switch (function) {
                case "recommend":
                    x = Integer.parseInt(st.nextToken());
                    sb.append(recommend(x)).append("\n");
                    break;
                case "add":
                    p = Integer.parseInt(st.nextToken());
                    l = Integer.parseInt(st.nextToken());
                    add(p, l);
                    break;
                case "solved":
                    p = Integer.parseInt(st.nextToken());
                    solved(p);
                    break;
            }
        }

        return sb.toString();
    }

    private int recommend(int x) {
        if(x == 1) {
            return problemSet.first().getId();
        }

        return problemSet.last().getId();
    }

    private void add(int p, int l) {
        Problem problem = new Problem(p, l);

        problemSet.add(problem);
        problemMap.put(p, problem);
    }

    private void solved(int p) {
        problemSet.remove(problemMap.get(p));
        problemMap.remove(p);
    }

    static class Problem implements Comparable<Problem> {
        private int id;
        private int level;

        public Problem(int id) {
            this.id = id;
            this.level = 0;
        }

        public Problem(int id, int level) {
            this.id = id;
            this.level = level;
        }

        public int getId() {
            return id;
        }

        @Override
        public int compareTo(Problem o) {
            if(this.level == o.level) {
                return o.id - this.id;
            }
            
            return o.level - this.level;
        }

        @Override
        public boolean equals(Object obj) {
            if(this == obj) {
                return true;
            }
            if(!(obj instanceof Problem)) {
                return false;
            }
            Problem p = (Problem) obj;

            return Objects.equals(this.id, p.id) && Objects.equals(this.level, p.level);
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.id, this.level);
        }
    }
}

public class Problem21939 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        List<Solution21939.Problem> list = new ArrayList<>(n);
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            list.add(new Solution21939.Problem(p, l));
        }
        int m = Integer.parseInt(br.readLine());
        String[] arr = new String[m];
        for(int i = 0; i < m; i++) {
            arr[i] = br.readLine();
        }
        
        bw.write(new Solution21939(list, arr).solve());
        bw.flush();
        bw.close();
    }
}
