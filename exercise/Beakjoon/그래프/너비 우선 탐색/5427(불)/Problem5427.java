import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution5427 {
    private final int[] DX = {0, 1, 0, -1};
    private final int[] DY = {1, 0, -1, 0};
    private int width;
    private int height;
    private char[][] map;
    private boolean[][] visited;
    private int[] start;
    private List<int[]> fires;

    public Solution5427(int width, int height, char[][] map, int[] start, List<int[]> fires) {
        this.width = width;
        this.height = height;
        this.map = map;
        this.visited = new boolean[height][width];
        this.start = start;
        this.fires = fires;
    }

    public String solve() {
        return String.valueOf(bfs(start, fires));
    }

    private String bfs(int[] start, List<int[]> fires) {
        Queue<int[]> queue = new ArrayDeque<>();
        for(int[] fire : fires) {
            queue.offer(new int[] {fire[0], fire[1], 0, 0});
            visited[fire[0]][fire[1]] = true;
        }
        queue.offer(new int[] {start[0], start[1], 0, 1});
        visited[start[0]][start[1]] = true;

        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int cx = curr[0];
            int cy = curr[1];
            int ct = curr[2];
            int type = curr[3];

            if(type == 1 && (cx == 0 || cx == height - 1 || cy == 0 || cy == width - 1)) {
                return String.valueOf(ct + 1);
            }

            for(int i = 0; i < 4; i++) {
                int nx = cx + DX[i];
                int ny = cy + DY[i];
                int nt = ct + 1;

                if(!(0 <= nx && nx < height && 0 <= ny && ny < width)) {
                    continue;
                }
                if(visited[nx][ny]) {
                    continue;
                }
                if(map[nx][ny] == '#') {
                    continue;
                }

                queue.offer(new int[] {nx, ny, nt, type});
                visited[nx][ny] = true;
            }
        }

        return "IMPOSSIBLE";
    }
}

public class Problem5427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            char[][] arr = new char[h][w];
            int[] start = new int[2];
            List<int[]> fires = new ArrayList<>();
            for(int x = 0; x < h; x++) {
                char[] chars = br.readLine().toCharArray();
                for(int y = 0; y < w; y++) {
                    arr[x][y] = chars[y];
                    if(chars[y] == '@') {
                        start[0] = x;
                        start[1] = y;
                    }
                    if(chars[y] == '*') {
                        fires.add(new int[] {x, y});
                    }
                }
            }
            bw.write(new Solution5427(w, h, arr, start, fires).solve());
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }
}
