import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution1189 {
    private final int[] DX = {0, 1, 0, -1};
    private final int[] DY = {1, 0, -1, 0};
    private int height;
    private int width;
    private int distance;
    private char[][] map;
    private boolean[][] visited;
    private int count;

    public Solution1189(int height, int width, int distance, char[][] map) {
        this.height = height;
        this.width = width;
        this.distance = distance;
        this.map = map;
        this.visited = new boolean[height][width];
        this.count = 0;
    }

    public String solve() {
        visited[height - 1][0] = true;
        dfs(height - 1, 0, 1);
        visited[height - 1][0] = false;

        return String.valueOf(count);
    }

    private void dfs(int cx, int cy, int cd) {
        if(cx == 0 && cy == width - 1) {
            if(cd == distance) {
                count++;
            }
            
            return;
        }

        for(int i = 0; i < 4; i++) {
            int nx = cx + DX[i];
            int ny = cy + DY[i];
            int nd = cd + 1;

            if(!(0 <= nx && nx < height && 0 <= ny && ny < width)) {
                continue;
            }
            if(map[nx][ny] == 'T') {
                continue;
            }
            if(visited[nx][ny]) {
                continue;
            }

            visited[nx][ny] = true;
            dfs(nx, ny, nd);
            visited[nx][ny] = false;
        }
    }
}

public class Problem1189 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        char[][] arr = new char[r][c];
        for(int i = 0; i < r; i++) {
            char[] chars = br.readLine().toCharArray();
            for(int j = 0; j < c; j++) {
                arr[i][j] = chars[j];
            }
        }

        bw.write(new Solution1189(r, c, k, arr).solve());
        bw.flush();
        bw.close();
    }
}
