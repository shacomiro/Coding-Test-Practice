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

class Solution4179 {
    private final int[] DX = {1, 0, -1 ,0};
    private final int[] DY = {0, 1, 0, -1};
    private int height;
    private int width;
    private char[][] map;
    private boolean[][][] visited;
    private int[] start;
    private List<int[]> fires;

    public Solution4179(int height, int width, char[][] map, int[] start, List<int[]> fires) {
        this.height = height;
        this.width = width;
        this.map = map;
        this.visited = new boolean[2][height][width];
        this.start = start;
        this.fires = fires;
    }

    public String solve() {
        return bfs();
    }

    private String bfs() {
        Queue<int[]> queue = new ArrayDeque<>();
        for(int[] fire : fires) {
            queue.offer(new int[] {1, fire[0], fire[1], 0});
            visited[1][fire[0]][fire[1]] = true;
        }
        queue.offer(new int[] {0, start[0], start[1], 0});
        visited[0][start[0]][start[1]] = true;

        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int type = curr[0];
            int cx = curr[1];
            int cy = curr[2];
            int time = curr[3];

            for(int i = 0; i < 4; i++) {
                int nx = cx + DX[i];
                int ny = cy + DY[i];

                if(!(0 <= nx && nx < height && 0 <= ny && ny < width)) {
                    if(type == 0) {
                        return String.valueOf(time + 1);
                    }
                    continue;
                }
                if((type == 0 && visited[0][nx][ny]) || (type == 1 && visited[1][nx][ny])) {
                    continue;
                }
                if(map[nx][ny] == '#') {
                    continue;
                }
                if(type == 0 && map[nx][ny] == 'F') {
                    continue;
                }
                if(type == 1 && map[nx][ny] == '.') {
                    map[nx][ny] = 'F';
                }

                queue.offer(new int[] {type, nx, ny, time + 1});
                visited[type][nx][ny] = true;
            }
        }

        return "IMPOSSIBLE";
    }
}

public class Problem4179 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        char[][] arr = new char[r][c];
        int[] start = new int[2];
        List<int[]> list = new ArrayList<>();
        for(int i = 0; i < r; i++) {
            char[] chars = br.readLine().toCharArray();
            for(int j = 0; j < c; j++) {
                char ch = chars[j];
                arr[i][j] = ch;

                if(ch == 'J') {
                    start[0] = i;
                    start[1] = j;
                }
                if(ch == 'F') {
                    list.add(new int[] {i, j});
                }
            }
        }

        bw.write(new Solution4179(r, c, arr, start, list).solve());
        bw.flush();
        bw.close();
    }
}
