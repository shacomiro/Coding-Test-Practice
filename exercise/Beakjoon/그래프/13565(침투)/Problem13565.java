import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution13565 {
    private static final int D_LENGTH = 4;
    private static final int[] DX = {1, 0, -1, 0};
    private static final int[] DY = {0, 1, 0, -1};
    private int width;
    private int height;
    private boolean[][] matter;
    private boolean[][] visited;
    private boolean isPercolate;

    public Solution13565(int width, int height, boolean[][] matter) {
        this.width = width;
        this.height = height;
        this.matter = matter;
        this.visited = new boolean[height][width];
        this.isPercolate = false;
    }

    public String solve() {
        for(int y = 0; y < width; y++) {
            if(visited[0][y]) {
                continue;
            }
            if(!matter[0][y]) {
                continue;
            }

            bfs(new int[] {0, y});
        }

        return isPercolate ? "YES" : "NO";
    }

    private void bfs(int[] start) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start[0]][start[1]] = true;

        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int cx = curr[0];
            int cy = curr[1];

            if(cx + 1 == height) {
                isPercolate = true;
                break;
            }

            for(int i = 0; i < D_LENGTH; i++) {
                int nx = cx + DX[i];
                int ny = cy + DY[i];

                if(!(0 <= nx && nx < height && 0 <= ny && ny < width)) {
                    continue;
                }
                if(visited[nx][ny]) {
                    continue;
                }
                if(!matter[nx][ny]) {
                    continue;
                }

                queue.offer(new int[] {nx, ny});
                visited[nx][ny] = true;
            }
        }
    }
}

public class Problem13565 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st1.nextToken());
        int n = Integer.parseInt(st1.nextToken());
        boolean[][] arr = new boolean[m][n];
        for(int i = 0; i < m; i++) {
            String str = br.readLine();

            for(int j = 0; j < n; j++) {

                switch (str.charAt(j)) {
                    case '0':
                        arr[i][j] = true;
                        break;
                    case '1':
                        arr[i][j] = false;
                        break;
                }
            }
        }

        bw.write(new Solution13565(n, m, arr).solve());
        bw.flush();
        bw.close();
    }
}
