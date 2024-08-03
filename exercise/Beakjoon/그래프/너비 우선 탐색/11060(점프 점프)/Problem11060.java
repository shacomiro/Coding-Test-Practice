import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution11060 {
    private int[] maze;
    private boolean[] visited;

    public Solution11060(int size, int[] maze) {
        this.maze = maze;
        this.visited = new boolean[size];
    }

    public String solve() {
        return String.valueOf(bfs());
    }

    private int bfs() {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {0, 0});
        visited[0] = true;

        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int cp = curr[0];
            int cj = curr[1];

            if(cp == maze.length - 1) {
                return cj;
            }

            for(int i = 1; i <= maze[cp]; i++) {
                int np = cp + i;
                int nj = cj + 1;

                if(!(0 <= np && np < maze.length)) {
                    continue;
                }
                if(visited[np]) {
                    continue;
                }

                queue.offer(new int[] {np, nj});
                visited[np] = true;
            }
        }

        return -1;
    }
}

public class Problem11060 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(new Solution11060(n, arr).solve());
        bw.flush();
        bw.close();
    }    
}
