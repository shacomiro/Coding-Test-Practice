import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution2589 {
    private final int[] DX = {0, 1, 0, -1};
    private final int[] DY = {1, 0, -1, 0};
    private int width;
    private int height;
    private char[][] map;
    private boolean[][] visited;

    public Solution2589(int width, int height, char[][] map) {
        this.width = width;
        this.height = height;
        this.map = map;
    }

    public String solve() {
        int maxDistance = 0;

        for(int x = 0; x < height; x++) {
            for(int y = 0; y < width; y++) {
                if(map[x][y] == 'W') {
                    continue;
                }

                visited = new boolean[height][width];
                maxDistance = Math.max(maxDistance, bfs(new int[] {x, y}));
            }
        }

        return String.valueOf(maxDistance);
    }

    private int bfs(int[] start) {
        int distance = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {start[0], start[1], 0});
        visited[start[0]][start[1]] = true;

        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int cx = curr[0];
            int cy = curr[1];
            int cd = curr[2];

            distance = cd;

            for(int i = 0; i < 4; i++) {
                int nx = cx + DX[i];
                int ny = cy + DY[i];
                int nd = cd + 1;

                if(!(0 <= nx && nx < height && 0 <= ny && ny < width)) {
                    continue;
                }
                if(visited[nx][ny]) {
                    continue;
                }
                if(map[nx][ny] == 'W') {
                    continue;
                }

                queue.offer(new int[] {nx, ny, nd});
                visited[nx][ny] = true;
            }
        }

        return distance;
    }
}

public class Problem2589 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        char[][] arr = new char[h][w];
        for(int i = 0; i < h; i++) {
            char[] chars = br.readLine().toCharArray();
            for(int j = 0; j < w; j++) {
                arr[i][j] = chars[j];
            }
        }

        bw.write(new Solution2589(w, h, arr).solve());
        bw.flush();
        bw.close();
    }
}
