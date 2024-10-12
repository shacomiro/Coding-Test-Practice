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

class Solution11725 {
    private int size;
    private List<List<Integer>> tree;
    private Set<Integer> visited;
    private int[] parents;

    public Solution11725(int size, List<List<Integer>> tree) {
        this.size = size;
        this.tree = tree;
        this.visited = new HashSet<>(size);
        this.parents = new int[size + 1];
    }

    public String solve() {
        StringBuilder sb = new StringBuilder();

        bfs();
        
        for(int i = 2; i <= size; i++) {
            sb.append(parents[i]).append("\n");
        }

        return sb.toString();
    }

    private void bfs() {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        visited.add(1);

        while(!queue.isEmpty()) {
            int parent = queue.poll();

            for(int child : tree.get(parent)) {
                if(visited.contains(child)) {
                    continue;
                }
                
                parents[child] = parent;
                queue.offer(child);
                visited.add(child);
            }
        }
    }
}

public class Problem11725 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        List<List<Integer>> list = new ArrayList<>(n + 1);
        for(int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        for(int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());

            list.get(parent).add(child);
            list.get(child).add(parent);
        }

        bw.write(new Solution11725(n, list).solve());
        bw.flush();
        bw.close();
    }
}
