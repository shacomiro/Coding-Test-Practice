import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class HideAndSeek {
    private static boolean[] visited;
    private static Queue<Integer> queue;

    public static int solution(int n, int k) {
        if(n == k) {
            return 0;
        }
        visited = new boolean[100001];
        queue = new LinkedList<>();

        return bfs(n, k);
    }

    private static int bfs(int start, int target) {
        int[] nextPos = new int[3];
        int time = 0;

        queue.add(start);
        visited[start] = true;

        searching:while(!queue.isEmpty()) {
            int size = queue.size();

            for(int i = 0; i < size; i++) {
                int pos = queue.poll();

                if(pos == target) {
                    break searching;
                }
    
                nextPos[0] = pos - 1;
                nextPos[1] = pos + 1;
                nextPos[2] = pos * 2;
    
                for(int next : nextPos) {
                    if(!(0 <= next && next <= 100000)) {
                        continue;
                    }
    
                    if(visited[next]) {
                        continue;
                    }
    
                    queue.add(next);
                    visited[next] = true;
                }
            }

            time++;
        }

        return time;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        bw.write(String.valueOf(solution(n, k)));
        bw.flush();
        bw.close();
    }
}
