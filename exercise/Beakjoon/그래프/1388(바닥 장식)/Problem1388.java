import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution1388 {
    private final int[] DX = {0, 0, -1, 1};
    private final int[] DY = {-1, 1, 0, 0,};
    private int width;
    private int height;
    private char[][] floor;
    private boolean[][] visited;

    public Solution1388(int height, int width, char[][] floor) {
        this.width = width;
        this.height = height;
        this.floor = floor;
        this.visited = new boolean[height][width];
    }

    public String solve() {
        int count = 0;

        for(int x = 0; x < height; x++) {
            for(int y = 0; y < width; y++) {
                if(visited[x][y]) {
                    continue;
                }

                bfs(new int[] {x, y});
                count++;
            }
        }

        return String.valueOf(count);
    }

    public void bfs(int[] start) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start[0]][start[1]] = true;

        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int cx = curr[0];
            int cy = curr[1];
            int from = 0;
            int to = 4;

            switch (floor[cx][cy]) {
                case '-':
                    from = 0;
                    to = 2;
                    break;
                case '|':
                    from = 2;
                    to = 4;
                    break;
            }

            for(int i = from; i < to; i++) {
                int nx = cx + DX[i];
                int ny = cy + DY[i];

                if(!(0 <= nx && nx < height && 0 <= ny && ny < width)) {
                    continue;
                }

                if(visited[nx][ny]) {
                    continue;
                }

                if(floor[nx][ny] != floor[start[0]][start[1]]) {
                    continue;
                }

                queue.offer(new int[] {nx, ny});
                visited[nx][ny] = true;
            }
        }
    }
}

public class Problem1388 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] arr = new char[n][m];
        for(int i = 0; i < n; i++) {
            char[] line = br.readLine().toCharArray();
            for(int j = 0; j < m; j++) {
                arr[i][j] = line[j];
            }
        }

        bw.write(new Solution1388(n, m ,arr).solve());
        bw.flush();
        bw.close();
    }
}
