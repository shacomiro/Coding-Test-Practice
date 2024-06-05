import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution1926 {
    private static final int D_LENGTH = 4;
    private static final int[] DX = {1, 0, -1, 0};
    private static final int[] DY = {0, 1, 0, -1};
    private int width;
    private int height;
    private int[][] canvas;
    private boolean[][] visited;

    public Solution1926(int n, int m, int[][] arr) {
        this.width = n;
        this.height = m;
        this.canvas = arr;
        this.visited = new boolean[n][m];
    }

    public String solve() {
        int paintCount = 0;
        int maxPaintSize = 0;

        for(int x = 0; x < width; x++) {
            for(int y = 0; y < height; y++) {
                if(canvas[x][y] == 0 || visited[x][y]) {
                    continue;
                }

                paintCount++;
                maxPaintSize = Math.max(maxPaintSize, bfs(new int[] {x, y}));
            }
        }

        return paintCount + "\n" + maxPaintSize;
    }

    private int bfs(int[] start) {
        int paintSize = 0;

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start[0]][start[1]] = true;

        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int cx = curr[0];
            int cy = curr[1];

            paintSize++;

            for(int i = 0; i < D_LENGTH; i++) {
                int nx = cx + DX[i];
                int ny = cy + DY[i];

                if(!(0 <= nx && nx < width && 0 <= ny && ny < height)) {
                    continue;
                }

                if(canvas[nx][ny] == 0 || visited[nx][ny]) {
                    continue;
                }

                queue.offer(new int[] {nx, ny});
                visited[nx][ny] = true;
            }
        }

        return paintSize;
    }
}

public class Problem1926 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st1.nextToken());
        int m = Integer.parseInt(st1.nextToken());
        int[][] arr = new int[n][m];
        for(int i = 0; i < n; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());

            for(int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st2.nextToken());
            }
        }

        bw.write(new Solution1926(n, m, arr).solve());
        bw.flush();
        bw.close();
    }    
}
