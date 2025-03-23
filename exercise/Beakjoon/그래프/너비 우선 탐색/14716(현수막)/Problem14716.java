import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution14716 {
    private static int[] DX = {0, 1, 1, 1, 0,  -1, -1, -1};
    private static int[] DY = {1, 1, 0, -1, -1, -1, 0, 1};
    private int m;
    private int n;
    private int[][] graph;
    private boolean[][] visited;

    public Solution14716(int m, int n, int[][] graph) {
        this.m = m;
        this.n = n;
        this.graph = graph;
        this.visited = new boolean[m][n];
    }

    public String solve() {
        int count = 0;

        for(int x = 0; x < m; x++) {
            for(int y = 0; y < n; y++) {
                if(graph[x][y] == 1 && visited[x][y] == false) {
                    bfs(new int[] {x, y});
                    count++;
                }
            }
        }

        return String.valueOf(count);
    }

    private void bfs(int[] start) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start[0]][start[1]] = true;

        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int cx = curr[0];
            int cy = curr[1];

            for(int i = 0; i < 8; i++) {
                int nx = cx + DX[i];
                int ny = cy + DY[i];

                if(!(0 <= nx && nx < m && 0 <= ny && ny < n)) {
                    continue;
                }
                if(graph[nx][ny] == 0) {
                    continue;
                }
                if(visited[nx][ny]) {
                    continue;
                }

                queue.offer(new int[] {nx, ny});
                visited[nx][ny] = true;
            }
        }
    }
}

public class Problem14716 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[][] arr = new int[m][n];
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bw.write(new Solution14716(m, n, arr).solve());
        bw.flush();
        bw.close();
    }
}
