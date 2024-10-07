import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution1766 {
    private int size;
    private List<List<Integer>> graph;
    private int[] inDegree;

    public Solution1766(int size, List<int[]> priorities) {
        this.size = size;
        this.graph = new ArrayList<>(size + 1);
        this.inDegree = new int[size + 1];

        for(int i = 0; i <= size; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] p : priorities) {
            int first = p[0];
            int next = p[1];

            graph.get(first).add(next);
            inDegree[next]++;
        }
    }

    public String solve() {
        Queue<Integer> pq = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();

        for(int id = 1; id <= size; id++) {
            if(inDegree[id] == 0) {
                pq.offer(id);
            }
        }

        while(!pq.isEmpty()) {
            int curr = pq.poll();
            sb.append(curr).append(" ");

            for(int next : graph.get(curr)) {
                inDegree[next]--;

                if(inDegree[next] == 0) {
                    pq.offer(next);
                }
            }
        }

        return sb.toString();
    }
}

public class Problem1766 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.add(new int[] {a, b});
        }

        bw.write(new Solution1766(n, list).solve());
        bw.flush();
        bw.close();
    }
}
