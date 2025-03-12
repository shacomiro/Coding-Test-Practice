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

class Solution6118 {
    private List<List<Integer>> graph;

    public Solution6118(int n, int m, int[][] edges) {
        initGraph(n, m, edges);
    }

    private void initGraph(int n, int m, int[][] edges) {
        graph = new ArrayList<>(n + 1);

        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
    }

    public String solve() {
        int[] result = bfs(1);

        return String.valueOf(result[0] + " " + result[1] + " " + result[2]);
    }
    
    private int[] bfs(int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(start);
        visited.add(start);

        int distance = -1;
        int size = 0;
        int minNumber = 0;

        while(!queue.isEmpty()) {
            int qSize = queue.size();
            int min = graph.size();
            distance++;

            for(int i = 0; i < qSize; i++) {
                int curr = queue.poll();
                min = Math.min(min, curr);

                for(int next : graph.get(curr)) {
                    if(visited.contains(next)) {
                        continue;
                    }

                    queue.offer(next);
                    visited.add(next);
                }
            }

            minNumber = min;
            size = qSize;
        }

        return new int[] {minNumber, distance, size};
    }
}

public class Problem6118 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[m][2];
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        bw.write(new Solution6118(n, m, arr).solve());
        bw.flush();
        bw.close();
    }
}
