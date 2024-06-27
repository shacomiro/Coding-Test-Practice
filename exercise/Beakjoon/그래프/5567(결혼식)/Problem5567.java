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

class Solution5567 {
    private List<List<Integer>> graph;
    private Set<Integer> visited;
    private int count;

    public Solution5567(List<List<Integer>> graph) {
        this.graph = graph;
        this.visited = new HashSet<>();
        this.count = 0;
    }

    public String solve() {
        bfs(1);

        return String.valueOf(count);
    }

    public void bfs(int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        visited.add(start);
        int depth = 0;

        while(!queue.isEmpty()) {
            depth++;
            if(depth == 3) {
                break;
            }

            int qSize = queue.size();
            for(int i = 0; i < qSize; i++) {
                int curr = queue.poll();

                for(int friend : graph.get(curr)) {
                    if(visited.contains(friend)) {
                        continue;
                    }

                    queue.offer(friend);
                    visited.add(friend);
                    count++;
                }
            }
        }
    }
}

public class Problem5567 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        List<List<Integer>> list = new ArrayList<>(n + 1);
        for(int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            list.get(b).add(a);
        }

        bw.write(new Solution5567(list).solve());
        bw.flush();
        bw.close();
    }
}
