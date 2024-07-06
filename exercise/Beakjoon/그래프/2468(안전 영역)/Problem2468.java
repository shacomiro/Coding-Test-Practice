import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution2468 {
    private final int[] DX = {1, 0, -1, 0};
    private final int[] DY = {0, 1, 0, -1};
    private int size;
    private int[][] map;
    
    public Solution2468(int size, int[][] map) {
        this.size = size;
        this.map = map;
    }

    public String solve() {
        boolean[][] visited;
        boolean isFlood;
        int maxAreaCount = 0;
        int areaCount;

        for(int rain = 0; rain < 100; rain++) {
            visited = new boolean[size][size];
            areaCount = 0;
            isFlood = true;

            for(int x = 0; x < size; x++) {
                for(int y = 0; y < size; y++) {
                    if(visited[x][y]) {
                        continue;
                    }
                    if(map[x][y] <= rain) {
                        continue;
                    }
    
                    isFlood = false;
                    bfs(new int[] {x, y}, rain, visited);
                    areaCount++;
                }
            }

            if(isFlood) {
                break;
            }

            maxAreaCount = Math.max(maxAreaCount, areaCount);
        }

        return String.valueOf(maxAreaCount);
    }

    private void bfs(int[] start, int rain, boolean[][] visited) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start[0]][start[1]] = true;

        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int cx = curr[0];
            int cy = curr[1];

            for(int i = 0; i < 4; i++) {
                int nx = cx + DX[i];
                int ny = cy + DY[i];

                if(!(0 <= nx && nx < size && 0 <= ny && ny < size)) {
                    continue;
                }
                if(visited[nx][ny]) {
                    continue;
                }
                if(map[nx][ny] <= rain) {
                    continue;
                }

                queue.offer(new int[] {nx, ny});
                visited[nx][ny] = true;
            }
        }
    }
}

public class Problem2468 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bw.write(new Solution2468(n, arr).solve());
        bw.flush();
        bw.close();
    }
}
