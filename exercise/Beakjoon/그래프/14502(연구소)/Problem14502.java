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

class Solution14502 {
    private final int[] DX = {0, 1, 0, -1};
    private final int[] DY = {1, 0, -1, 0};
    private int width;
    private int height;
    private int[][] labs;
    private List<int[]> virus;
    private int wallCnt;
    private int minVirusCnt;

    public Solution14502(int height, int width, int[][] labs, List<int[]> virus, int wallCnt) {
        this.width = width;
        this.height = height;
        this.labs = labs;
        this.virus = virus;
        this.wallCnt = wallCnt;
        this.minVirusCnt = height * width;
    }

    public String solve() {
        dfs(0);

        return String.valueOf(height * width - (wallCnt + 3 + minVirusCnt));
    }

    private void dfs(int depth) {
        if(depth == 3) {
            minVirusCnt = Math.min(minVirusCnt, bfs());

            return;
        }

        for(int x = 0; x < height; x++) {
            for(int y = 0; y < width; y++) {
                if(labs[x][y] == 0) {
                    labs[x][y] = 1;
                    dfs(depth + 1);
                    labs[x][y] = 0;
                }
            }
        }
    }

    private int bfs() {
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[height][width];
        int virusCnt = 0;

        for(int[] v : virus) {
            queue.offer(v);
            visited[v[0]][v[1]] = true;
        }

        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int cx = curr[0];
            int cy = curr[1];

            virusCnt++;

            for(int i = 0; i < 4; i++) {
                int nx = cx + DX[i];
                int ny = cy + DY[i];

                if(!(0 <= nx && nx < height && 0 <= ny && ny < width)) {
                    continue;
                }
                if(visited[nx][ny]) {
                    continue;
                }
                if(labs[nx][ny] == 1) {
                    continue;
                }

                queue.offer(new int[] {nx, ny});
                visited[nx][ny] = true;
            }
        }

        return virusCnt;
    }
}

public class Problem14502 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        int cnt = 0;
        List<int[]> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i][j] = num;

                if(num == 1) {
                    cnt++;
                } else if(num == 2) {
                    list.add(new int[] {i, j});
                }
            }
        }

        bw.write(new Solution14502(n, m, arr, list, cnt).solve());
        bw.flush();
        bw.close();
    }
}
