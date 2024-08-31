import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution1600 {
    private final int[] DX = {1, 0, -1, 0};
    private final int[] DY = {0, 1, 0, -1};
    private final int[] JX = {2, 1, -2, -1, 2, 1, -2, -1};
    private final int[] JY = {1, 2, 1, 2, -1, -2, -1, -2};
    private int ability;
    private int width;
    private int height;
    private int[][] map;
    private boolean[][][] visited;

    public Solution1600(int ability, int width, int height, int[][] map) {
        this.ability = ability;
        this.width = width;
        this.height = height;
        this.map = map;
        this.visited = new boolean[ability + 1][height][width];
    }

    public String solve() {
        return String.valueOf(bfs());
    }

    private int bfs() {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {0, 0, ability, 0});
        visited[ability][0][0] = true;

        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int cx = curr[0];
            int cy = curr[1];
            int ca = curr[2];
            int cm = curr[3];

            if(cx == height - 1 && cy == width - 1) {
                return cm;
            }

            if(ca > 0) {
                for(int i = 0; i < 8; i++) {
                    int nx = cx + JX[i];
                    int ny = cy + JY[i];
                    int na = ca - 1;
                    int nm = cm + 1;
    
                    if(isValidMove(nx, ny, na)) {
                        queue.offer(new int[] {nx, ny, na, nm});
                        visited[na][nx][ny] = true;
                    }
                    
                }
            }

            for(int i = 0; i < 4; i++) {
                int nx = cx + DX[i];
                int ny = cy + DY[i];
                int na = ca;
                int nm = cm + 1;

                if(isValidMove(nx, ny, na)) {
                    queue.offer(new int[] {nx, ny, na, nm});
                    visited[na][nx][ny] = true;
                }
            }
        }

        return -1;
    }

    private boolean isValidMove(int nx, int ny, int na) {
        if(!(0 <= nx && nx < height && 0 <= ny && ny < width)) {
            return false;
        }
        if(visited[na][nx][ny]) {
            return false;
        }
        if(map[nx][ny] == 1) {
            return false;
        }
        if(na < 0) {
            return false;
        }

        return true;
    }
}

public class Problem1600 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int k = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int[][] arr = new int[h][w];
        for(int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < w; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bw.write(new Solution1600(k, w, h, arr).solve());
        bw.flush();
        bw.close();
    }
}
