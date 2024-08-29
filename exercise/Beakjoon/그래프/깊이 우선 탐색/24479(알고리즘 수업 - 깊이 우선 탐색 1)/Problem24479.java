import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

class Solution24479 {
    private List<List<Integer>> graph;
    private boolean[] visited;
    private int start;
    private int[] order;
    private int orderCnt;

    public Solution24479(List<List<Integer>> graph, List<int[]> edges, int start) {
        this.graph = graph;
        this.visited = new boolean[graph.size()];
        this.start = start;
        this.order = new int[graph.size()];
        this.orderCnt = 1;

        Collections.sort(edges, new Comparator<int[]>() {
            @Override
            public int compare(int[] e1, int[] e2) {
                if(e1[0] == e2[0]) {
                    return e1[1] - e2[1];
                }
                return e1[0] - e2[0];
            }
        });
        for(int[] e : edges) {
            graph.get(e[0]).add(e[1]);
        }
    }

    public String solve() {
        dfs(start);

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < order.length; i++) {
            sb.append(order[i]).append("\n");
        }

        return sb.toString();
    }

    private void dfs(int cx) {
        order[cx] = orderCnt++;
        visited[cx] = true;
        for(int nx : graph.get(cx)) {
            if(!visited[nx]) {
                dfs(nx);
            }
        }
    }
}

public class Problem24479 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        List<List<Integer>> list1 = new ArrayList<>(n + 1);
        for(int i = 0; i <= n; i++) {
            list1.add(new ArrayList<>());
        }
        List<int[]> list2 = new ArrayList<>(m);
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            list2.add(new int[] {u, v});
            list2.add(new int[] {v, u});
        }

        bw.write(new Solution24479(list1, list2, r).solve());
        bw.flush();
        bw.close();
    }
}
