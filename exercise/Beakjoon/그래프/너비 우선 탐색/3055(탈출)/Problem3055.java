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

class Solution3055 {
    private final int[] DX = {0, 1, 0, -1};
    private final int[] DY = {1, 0, -1, 0};
    private int height;
    private int width;
    private char[][] map;
    private boolean[][] visited;
    private int[] start;
    private List<int[]> water;

    public Solution3055(int height, int width, char[][] map, int[] start, List<int[]> water) {
        this.height = height;
        this.width = width;
        this.map = map;
        this.visited = new boolean[height][width];
        this.start = start;
        this.water = water;
    }

    public String solve() {
        int result = bfs(start, water);

        return String.valueOf(result != -1 ? result : "KAKTUS");
    }

    private int bfs(int[] start, List<int[]> water) {
        Queue<int[]> queue = new ArrayDeque<>();
        for(int[] w : water) {
            queue.offer(new int[] {w[0], w[1], 0, 0});
            visited[w[0]][w[1]] = true;
        }
        queue.offer(new int[] {start[0], start[1], 0, 1});
        visited[start[0]][start[1]] = true;

        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int cx = curr[0];
            int cy = curr[1];
            int cd = curr[2];
            int type = curr[3];

            if(map[cx][cy] == 'D') {
                return cd;
            }

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
                if(map[nx][ny] == 'X') {
                    continue;
                }
                if(type == 0 && map[nx][ny] == 'D') {
                    continue;
                }
                if(type == 1 && map[nx][ny] == '*') {
                    continue;
                }

                queue.offer(new int[] {nx, ny, nd, type});
                visited[nx][ny] = true;
            }
        }

        return -1;
    }
}

public class Problem3055 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        char[][] arr = new char[r][c];
        int[] s = new int[2];
        List<int[]> w = new ArrayList<>();
        for(int i = 0; i < r; i++) {
            char[] chars = br.readLine().toCharArray();
            for(int j = 0; j < c; j++) {
                char ch = chars[j];
                arr[i][j] = ch;

                if(ch == 'S') {
                    s[0] = i;
                    s[1] = j;
                }
                if(ch == '*') {
                    w.add(new int[] {i, j});
                }
            }
        }

        bw.write(new Solution3055(r, c, arr, s, w).solve());
        bw.flush();
        bw.close();
    }
}
