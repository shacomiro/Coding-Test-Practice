import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution2206 {
    private final int[] DX = {1, 0, -1, 0};
    private final int[] DY = {0, 1, 0, -1};
    private int height;
    private int width;
    private int[][] map;

    public Solution2206(int height, int width, int[][] map) {
        this.height = height;
        this.width = width;
        this.map = map;
    }

    public String solve() {
        return String.valueOf(bfs());
    }

    private int bfs() {
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][][] visited = new boolean[height][width][2];

        queue.offer(new int[] {0, 0, 0, 1});
        visited[0][0][0] = true;

        while(!queue.isEmpty()) {
                int[] curr = queue.poll();
                int cx = curr[0];
                int cy = curr[1];
                int cb = curr[2];
                int distance = curr[3];

                if(cx == height - 1 && cy == width - 1) {
                    return distance;
                }

                for(int i = 0; i < 4; i++) {
                    int nx = cx + DX[i];
                    int ny = cy + DY[i];
                    int nb = cb;

                    if(!(0 <= nx && nx < height && 0 <= ny && ny < width)) {
                        continue;
                    }
                    if(map[nx][ny] == 1) {
                        if(nb == 0) {
                            nb = 1;
                        } else {
                            continue;
                        }
                    }
                    if(visited[nx][ny][nb]) {
                        continue;
                    }

                    queue.offer(new int[] {nx, ny, nb, distance + 1});
                    visited[nx][ny][nb] = true;
                }
        }

        return -1;
    }
}

public class Problem2206 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        for(int i = 0; i < n; i++) {
            char[] chars = br.readLine().toCharArray();
            for(int j = 0; j < m; j++) {
                arr[i][j] = Character.getNumericValue(chars[j]);
            }
        }

        bw.write(new Solution2206(n, m, arr).solve());
        bw.flush();
        bw.close();
    }
}
