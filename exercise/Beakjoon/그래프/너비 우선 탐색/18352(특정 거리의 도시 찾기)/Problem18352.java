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
import java.util.TreeSet;

class Solution18352 {
    private int n;
    private int m;
    private int k;
    private int x;
    private List<List<Integer>> graph;

    public Solution18352(int n, int m, int k, int x, int[][] roads) {
        this.n = n;
        this.m = m;
        this.k = k;
        this.x = x;
        this.graph = new ArrayList<>(n + 1);

        initGraph(roads);
    }

    private void initGraph(int[][] roads) {
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] road : roads) {
            graph.get(road[0]).add(road[1]);
        }
    }

    public String solve() {
        StringBuilder sb = new StringBuilder();

        for(int c : bfs(x)) {
            sb.append(c).append("\n");
        }

        return (sb.length() == 0) ? String.valueOf(-1) : sb.toString();
    }

    private Set<Integer> bfs(int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();

        Set<Integer> kCities = new TreeSet<>();
        int distance = 0;

        queue.offer(start);
        visited.add(start);

        while(!queue.isEmpty() || distance <= k) {
            int qSize = queue.size();

            for(int i = 0; i < qSize; i++) {
                int curr = queue.poll();
    
                if(distance == k) {
                    kCities.add(curr);
                }
    
                for(int next : graph.get(curr)) {
                    if(visited.contains(next)) {
                        continue;
                    }
    
                    queue.offer(next);
                    visited.add(next);
                }
            }

            distance++;
        }

        return kCities;
    }
}

public class Problem18352 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int[][] arr = new int[m][2];
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        bw.write(new Solution18352(n, m, k, x, arr).solve());
        bw.flush();
        bw.close();
    }
}
