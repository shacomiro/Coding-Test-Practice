import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

class Solution2644 {
    private List<List<Integer>> degreeOfKindship;
    private int start;
    private int end;
    private Set<Integer> visited;

    public Solution2644(List<List<Integer>> degreeOfKindship, int start, int end) {
        this.degreeOfKindship = degreeOfKindship;
        this.start = start;
        this.end = end;
        this.visited = new HashSet<>(degreeOfKindship.size() - 1);
    }

    public String solve() {
        return String.valueOf(bfs(start, end));
    }

    private int bfs(int start, int end) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {start, 0});
        visited.add(start);

        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int cp = curr[0];
            int ck = curr[1];

            if(cp == end) {
                return ck;
            }

            for(int np : degreeOfKindship.get(cp)) {
                if(visited.contains(np)) {
                    continue;
                }

                queue.offer(new int[] {np, ck + 1});
                visited.add(np);
            }
        }

        return -1;
    }
}

public class Problem2644 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());
        List<List<Integer>> list = new ArrayList<>(n + 1);
        for(int i = 0; i < n + 1; i++) {
            list.add(new ArrayList<>());
        }
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list.get(x).add(y);
            list.get(y).add(x);
        }

        bw.write(new Solution2644(list, a, b).solve());
        bw.flush();
        bw.close();
    }
}
