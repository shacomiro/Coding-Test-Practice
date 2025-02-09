import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution14496 {
    private int a;
    private int b;
    private int n;
    private int m;
    private int[][] pairs;
    private List<List<Integer>> graph;

    public Solution14496(int a, int b, int n, int m, int[][] pairs) {
        this.a = a;
        this.b = b;
        this.n = n;
        this.m = m;
        this.pairs = pairs;
        this.graph = new ArrayList<>(n + 1);

        initGraph();
    }

    private void initGraph() {
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>(n + 1));
        }

        for(int[] pair : pairs) {
            graph.get(pair[0]).add(pair[1]);
            graph.get(pair[1]).add(pair[0]);
        }
    }

    public String solve() {
        return String.valueOf(bfs(a, b));
    }

    private int bfs(int a, int b) {
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n + 1];
        int cnt = 0;

        queue.offer(a);
        visited[a] = true;

        while(!queue.isEmpty()) {
            int qSize = queue.size();

            for(int i = 0; i < qSize; i++) {
                int curr = queue.poll();
    
                if(curr == b) {
                    return cnt;
                }
    
                for(int next : graph.get(curr)) {
                    if(visited[next]) {
                        continue;
                    }

                    queue.offer(next);
                    visited[next] = true;
                }
            }

            cnt++;
        }

        return -1;
    }
}

public class Problem14496 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[m][2];
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        bw.write(new Solution14496(a, b, n, m, arr).solve());
        bw.flush();
        bw.close();
    }
}
