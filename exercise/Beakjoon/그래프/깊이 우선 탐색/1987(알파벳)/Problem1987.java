import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution1987 {
    private final int[] DX = {0, 1, 0, -1};
    private final int[] DY = {1, 0, -1, 0};
    private int height;
    private int width;
    private char[][] map;
    private boolean[] visited;
    private int maxDistance;

    public Solution1987(int height, int width, char[][] map) {
        this.height = height;
        this.width = width;
        this.map = map;
        this.visited = new boolean[26];
        this.maxDistance = 0;
    }

    public String solve() {
        visited[map[0][0] - 'A'] = true;
        dfs(0, 0, 1);

        return String.valueOf(maxDistance);
    }

    private void dfs(int cx, int cy, int distance) {
        maxDistance = Math.max(maxDistance, distance);

        for(int i = 0; i < 4; i++) {
            int nx = cx + DX[i];
            int ny = cy + DY[i];

            if(!(0 <= nx && nx < height && 0 <= ny && ny < width)) {
                continue;
            }
            if(visited[map[nx][ny] - 'A']) {
                continue;
            }

            visited[map[nx][ny] - 'A'] = true;
            dfs(nx, ny, distance + 1);
            visited[map[nx][ny] - 'A'] = false;
        }
    }
}

public class Problem1987 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        char[][] arr = new char[r][c];
        for(int i = 0; i < r; i++) {
            char[] chars = br.readLine().toCharArray();
            for(int j = 0; j < c; j++) {
                arr[i][j] = chars[j];
            }
        }

        bw.write(new Solution1987(r, c, arr).solve());
        bw.flush();
        bw.close();
    }
}
