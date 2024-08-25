import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution3109 {
    private final int[] DX = {-1, 0, 1};
    private final int[] DY = {1, 1, 1};
    private int height;
    private int width;
    private char[][] map;
    private boolean[][] visited;
    private int pipe;

    public Solution3109(int height, int width, char[][] map) {
        this.height = height;
        this.width = width;
        this.map = map;
        this.visited = new boolean[height][width];
        this.pipe = 0;
    }

    public String solve() {
        for(int x = 0; x < height; x++) {
            visited[x][0] = true;
            dfs(x, 0, pipe);
        }

        return String.valueOf(pipe);
    }

    private void dfs(int cx, int cy, int cp) {
        if(cy == width - 1) {
            pipe++;
        } else {
            for(int i = 0; i < 3; i++) {
                int nx = cx + DX[i];
                int ny = cy + DY[i];
    
                if(!(0 <= nx && nx < height && 0 <= ny && ny < width)) {
                    continue;
                }
                if(visited[nx][ny]) {
                    continue;
                }
                if(map[nx][ny] == 'x') {
                    continue;
                }
                if(pipe != cp) {
                    continue;
                }

                visited[nx][ny] = true;
                dfs(nx, ny, cp);
            }
        }
    }
}

public class Problem3109 {
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

        bw.write(new Solution3109(r, c, arr).solve());
        bw.flush();
        bw.close();
    }
}
