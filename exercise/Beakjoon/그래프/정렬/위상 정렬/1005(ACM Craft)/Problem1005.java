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

class Solution1005 {
    private int size;
    private int[] delay;
    private List<List<Integer>> graph;
    private int[] inDegree;
    private int target;

    public Solution1005(int size, int[] delay, List<List<Integer>> graph, int[] inDegree, int target) {
        this.size = size;
        this.delay = delay;
        this.graph = graph;
        this.inDegree = inDegree;
        this.target = target;
    }

    public String solve() {
        return String.valueOf(topologicalSort(target));
    }

    private int topologicalSort(int target) {
        int[] maxDelay = new int[size + 1];
        Queue<Integer> queue = new ArrayDeque<>();
        
        for(int i = 1; i <= size; i++) {
            maxDelay[i] = delay[i];
            if(inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        for(int i = 0; i < size; i++) {
            int curr = queue.poll();

            for(int next : graph.get(curr)) {
                maxDelay[next] = Math.max(maxDelay[next], maxDelay[curr] + delay[next]);
                inDegree[next]--;

                if(inDegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        return maxDelay[target];
    }
}

public class Problem1005 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int[] arr1 = new int[n + 1];
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++) {
                arr1[j] = Integer.parseInt(st.nextToken());
            }
            int[] arr2 = new int[n + 1];
            List<List<Integer>> list = new ArrayList<>();
            for(int j = 0; j <= n; j++) {
                list.add(new ArrayList<>());
            }
            for(int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                int first = Integer.parseInt(st.nextToken());
                int next = Integer.parseInt(st.nextToken());

                list.get(first).add(next);
                arr2[next]++;
            }
            int w = Integer.parseInt(br.readLine());

            bw.write(new Solution1005(n, arr1, list, arr2, w).solve());
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
