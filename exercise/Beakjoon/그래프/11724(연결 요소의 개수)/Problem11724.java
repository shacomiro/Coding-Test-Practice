import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem11724 {
    public static int solution(ArrayList<ArrayList<Integer>> graph) {
        int graphSize = graph.size();
        boolean[] visited = new boolean[graphSize];
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;

        for(int i = 1; i < graphSize; i++) {
            if(visited[i]) {
                continue;
            }

            queue.add(i);
            visited[i] = true;

            while(!queue.isEmpty()) {
                int current = queue.poll();

                for(int next : graph.get(current)) {
                    if(visited[next]) {
                        continue;
                    }

                    queue.add(next);
                    visited[next] = true;
                }
            }

            queue.clear();
            count++;
        }
        
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st1.nextToken());
        int m = Integer.parseInt(st1.nextToken());
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(n + 1);
        for(int i = 1; i <= n + 1; i++) {
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < m; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st2.nextToken());
            int to = Integer.parseInt(st2.nextToken());

            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        bw.write(String.valueOf(solution(graph)));
        bw.flush();
        bw.close();
    }    
}
