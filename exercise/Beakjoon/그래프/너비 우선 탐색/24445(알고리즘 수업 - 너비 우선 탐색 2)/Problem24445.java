import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution24445 {
    private int n;
    private int r;
    private List<List<Integer>> graph;
    private boolean[] visited;
    private int[] order;

    public Solution24445(int n, int r, List<List<Integer>> graph) {
        this.n = n;
        this.r = r;
        this.graph = graph;
        this.visited = new boolean[n + 1];
        this.order = new int[n + 1];
    }

    public String solve() {
        for(List<Integer> g : graph) {
            Collections.sort(g, Collections.reverseOrder());
        }
        bfs(r);

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++) {
            sb.append(order[i]).append("\n");
        }

        return sb.toString();
    }

    private void bfs(int r) {
        Queue<Integer> queue = new ArrayDeque<>();
        visited[r] = true;
        queue.offer(r);
        int o = 1;

        while(!queue.isEmpty()) {
            int curr = queue.poll();
            order[curr] = o++;

            for(int next : graph.get(curr)) {
                if(!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
    }
}

public class Problem24445 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        List<List<Integer>> list = new ArrayList<>(n + 1);
        for(int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            list.get(u).add(v);
            list.get(v).add(u);
        }

        bw.write(new Solution24445(n, r, list).solve());
        bw.flush();
        bw.close();
    }
}
